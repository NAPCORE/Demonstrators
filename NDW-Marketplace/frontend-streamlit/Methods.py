import streamlit as st
import json
import requests
import initializeStates as inst
import staticVars as sv
import xml.etree.ElementTree as ET
import pandas as pd
from datetime import datetime


def CreateTable(json_data, variables, id_key=None, idName = None):
    table_data = {}

    if id_key:
        policy_id = json_data.get(id_key, "")
        truncated_policy_id = ("..." + policy_id[-16:]) if isinstance(policy_id, str) else "N/A"
        table_data[idName] = [truncated_policy_id]
    
    for variable in variables:
        value = json_data
        value = value.get(variable, "N/A")
        table_data[variable] = [value]
    st.table(pd.DataFrame(table_data))

def CheckDifferenceValues(newProviderUrl, newAssetId, newConsumerId, apiKey):
    if newProviderUrl != sv.providerUrl: return True
    if newAssetId != sv.assetId: return True
    if newConsumerId != sv.consumerId: return True
    if apiKey != sv.apiKey: return True


def RequestCatalogsApi(consumerIdStaticUrl, providerStaticUrl, providerUrl, assetId, consumerId, headers):
    FirstRequestDict = LoadJson(sv.firstJsonLocation)
    FirstRequestDict["counterPartyAddress"] = providerUrl + providerStaticUrl
    FirstRequestDict["querySpec"]["filterExpression"][0]["operandRight"] = assetId
    consumerIdUrl = str(consumerId + consumerIdStaticUrl)
    FirstRequestJson = json.dumps(FirstRequestDict)
    try:
        response = requests.post(url = consumerIdUrl, data=FirstRequestJson, headers=headers)
    except:
        DeleteInfo()
        st.session_state['currentError'] = "The Customer URL given is invalid"
        return
    try: 
        jsonResponse = response.json()
        st.session_state["RequestCatalogResponse"] = jsonResponse
    except:
        try:
            if not jsonResponse['dcat:dataset']:
                st.session_state['currentError'] = "No dataset found for the current assetID"
        except:
            st.session_state['currentError'] = "The response form the server is not in the JSON format we expected, the response looks like: " + str(jsonResponse)
        DeleteInfo()

def LoadJson(jsonName):
    FirstRequest = open(jsonName)
    FirstRequestDict = json.load(FirstRequest)
    return FirstRequestDict

def ShowJson(json):
    st.write(json)

def ShowIds(returnedJson):
    multiplePolicies = False
    try:
        with st.expander("Policies", expanded=True):
            has_policy = returnedJson["dcat:dataset"]["odrl:hasPolicy"]
            if isinstance(has_policy, list):
                multiplePolicies = len(has_policy) > 1
            else:
                multiplePolicies = False
            ShowPolicyButtons(returnedJson, multiplePolicies)
    except:
        try:
            if not returnedJson['dcat:dataset']:
                st.session_state['currentError'] = "No dataset found for the current assetID"
        except:
            st.session_state['currentError'] = "The response form the server is not in the JSON format we expected, the response looks like: " + str(returnedJson)

        DeleteInfo()

def ShowPolicyButtons(returnedJson, multiplePolicies):
    if multiplePolicies:
        for policy in returnedJson["dcat:dataset"]["odrl:hasPolicy"]:
            col1, col2 = st.columns([0.75,0.25], vertical_alignment="center")
            with col1:
                CreateTable(policy, ("odrl:permission", "odrl:prohibition", "odrl:obligation"), "@id", "ID")
            with col2:
                st.button("Start negotiation", on_click=OfferIdClicked, args=([policy][0],), key=[policy][0])
    else:
        col1, col2 = st.columns([0.75,0.25], vertical_alignment="center")
        with col1:
            policy_data = returnedJson["dcat:dataset"]["odrl:hasPolicy"]
            CreateTable(policy_data, ("odrl:permission", "odrl:prohibition", "odrl:obligation"), "@id", "ID")
        with col2:
            st.button("Start negotiation", on_click=OfferIdClicked, args=(returnedJson["dcat:dataset"]["odrl:hasPolicy"],), key=returnedJson["dcat:dataset"]["odrl:hasPolicy"])
    DeleteErrors()




def OfferIdClicked(policy):
    inst.show_catalog_callback()
    if policy != st.session_state['current_policy']:
        if 'auth_Code' in st.session_state:
            del st.session_state['auth_Code']
        if 'Data' in st.session_state:
            del st.session_state['Data']
        st.session_state['current_policy'] = policy
        GetCatalogCall(policy)

def GetCatalogCall(policy):
    FirstRequestDict = LoadJson(sv.firstJsonLocation)
    SecondRequestDict = LoadJson(sv.secondJsonLocation)
    SecondRequestDict["connectorAddress"] = FirstRequestDict["counterPartyAddress"]
    SecondRequestDict["connectorId"] = st.session_state["RequestCatalogResponse"]["edc:participantId"]
    SecondRequestDict["providerId"] = st.session_state["RequestCatalogResponse"]["edc:participantId"]
    SecondRequestDict["offer"]["offerId"] = policy["@id"]
    SecondRequestDict["offer"]["policy"]["odrl:permission"] = policy["odrl:permission"]
    SecondRequestDict["offer"]["policy"]["odrl:prohibition"] = policy["odrl:prohibition"]
    SecondRequestDict["offer"]["policy"]["odrl:obligation"] = policy["odrl:obligation"]
    SecondRequestDict["offer"]["policy"]["odrl:target"] = st.session_state["RequestCatalogResponse"]["dcat:dataset"]["@id"]

    SecondRequestJson = json.dumps(SecondRequestDict)

    secondRequestUrl = sv.consumerId + sv.edrStaticUrl
    try:
        response = requests.post(url = secondRequestUrl, data=SecondRequestJson, headers=sv.headers)
    except:
        st.session_state['currentError'] = "The Customer URL given is invalid"
        return
    try: 
        jsonResponse = response.json()
        st.session_state["InitiateEdrResponse"] = jsonResponse
        QueryCachedEdr()
    except:
        st.session_state['currentError'] = "The response form the server is not in the JSON format we expected, the response looks like: " + str(jsonResponse) + response.text


def QueryCachedEdr():
    query = sv.consumerId + "/management/edrs?assetId=" + sv.assetId
    response = requests.get(url=query, headers=sv.headers)
    jsonResponse = response.json()
    st.session_state['CachedEdr'] = jsonResponse


def GetAuthCodeButton(CachedJson):
    processId = GetTransferProcessId(CachedJson)
    st.button("Retrieve token", on_click=GetAuthCode, args=(processId,))

def GetTransferProcessId(CachedJson):
    negotiatedItem = CheckCachedJson(CachedJson)
    return negotiatedItem["edc:transferProcessId"]

def CheckCachedJson(cachedJson):
    for item in cachedJson:
        if item["tx:edrState"] == "NEGOTIATED":
            return item

def GetAuthCode(processId):
    try:
        if 'auth_Code' in st.session_state:
            return
        authCodeUrl = sv.consumerId + "/management/edrs/" + str(processId)
        response = requests.get(url=authCodeUrl, headers=sv.headers)
        responseJson = response.json()
        st.session_state['auth_Code'] = responseJson
    except Exception as e:
        st.session_state['currentError'] = "Error received: " + e

def GetDataButton(authCodeJson):
    edcEndpoint = str(GetEndPoint(authCodeJson))
    edcAuthCode = str(GetAuthCodeFromJson(authCodeJson))
    st.button("Get data", on_click=PrintData, args=(edcEndpoint,edcAuthCode,))

def GetEndPoint(authCodeJson):
    return authCodeJson["edc:endpoint"]

def GetAuthCodeFromJson(authCodeJson):
    return authCodeJson["edc:authCode"]

def PrintData(edcEndpoint, edcAuthCode):
    if "Data" in st.session_state:
        return
    newHeader = { "Authorization": edcAuthCode }
    response = requests.get(url=edcEndpoint, headers=newHeader)
    try:
        json_data = response.json()
        st.session_state["Data"] = json.dumps(json_data, indent=4)
        st.session_state["DownloadButtonText"] = "Download full Json"
    except ValueError:
        try:
            xml_content = ET.fromstring(response.content)
            xml_str = ET.tostring(xml_content, encoding="unicode")
            st.session_state["Data"] = xml_str
            st.session_state["DownloadButtonText"] = "Download full XML"
        except ET.ParseError:
            st.session_state['currentError'] = "De data is not in XML or JSON format"

def CheckSessionStates(ItemToCheck):
    return ItemToCheck in st.session_state


def DeleteInfo():
    if 'auth_Code' in st.session_state:
        del st.session_state['auth_Code']
    if 'Data' in st.session_state:
        del st.session_state['Data']
    if 'show_catalog' in st.session_state:
        st.session_state['show_catalog'] = False
    if 'CachedEdr' in st.session_state:
        del st.session_state['CachedEdr']
    if 'RequestCatalogResponse' in st.session_state:
        del st.session_state['RequestCatalogResponse']

def DeleteErrors():
    if 'currentError' in st.session_state:
            del st.session_state['currentError']

def CheckError():
    if 'currentError' in st.session_state:
        st.error(st.session_state['currentError'])

def UnixToNormalTime(unixTime):
    if isinstance(unixTime, datetime):
        return
    timeWithoutMili = unixTime / 1000
    correctDateTime = datetime.fromtimestamp(timeWithoutMili)
    return correctDateTime


def CreatePolicyTable():
    checkedJson = CheckCachedJson(st.session_state["CachedEdr"])
    unixTime = checkedJson["tx:expirationDate"]
    if not CheckSessionStates('correctTime'):
        st.session_state['correctTime'] = UnixToNormalTime(unixTime)
    checkedJson["tx:expirationDate"] = st.session_state['correctTime']
    st.session_state['policyTable'] = CreateTable(checkedJson, ("edc:providerId", "tx:edrState", "tx:expirationDate", "edc:transferProcessId"))
