import streamlit as st
import Methods
import initializeStates as inst
import staticVars as sv

inst.initStates()

providerUrlParam = st.query_params.get("providerUrl")
assetIdParam = st.query_params.get("assetUrl")

col1, col2 = st.columns([0.8, 0.2])

with col1:
    st.image("Images/CGI-logo.png", width=100)

with col2:
    st.image("Images/NTM.png", width=140)

with st.expander("Catalog variables", expanded=True):
    providerUrl = st.text_input( value= providerUrlParam if providerUrlParam != None else "https://dataprovider-controlplane.d37c3234d8454420babf.westeurope.aksapp.io", label="What is the Provider URL?", placeholder=providerUrlParam if providerUrlParam != None else "https://dataprovider-controlplane.d37c3234d8454420babf.westeurope.aksapp.io")
    assetId = st.text_input( value= assetIdParam if assetIdParam != None else "urn:uuid:c5a7fc0d-ba38-4c09-8620-35cc754da06b", label = "What is the Asset ID", placeholder=assetIdParam if assetIdParam != None else "urn:uuid:c5a7fc0d-ba38-4c09-8620-35cc754da06b")
    consumerId = st.text_input(label="What is the Consumer URL")
    apiKey = st.text_input(label="What is the API key")
    st.button("Search policies", on_click=inst.show_info_callback)


def process_request_catalog(providerUrl, assetId, consumerId, apiKey):
    st.session_state['first_load'] = False
    sv.headers["X-Api-Key"] = apiKey
    Methods.RequestCatalogsApi(sv.consumerIdStaticUrl, sv.providerStaticUrl, providerUrl, assetId, consumerId, sv.headers)
    sv.providerUrl = providerUrl
    sv.assetId = assetId
    sv.consumerId = consumerId 
    sv.apiKey = apiKey

def show_auth_code_and_data():
    if Methods.CheckSessionStates("Data"):
        st.text_area("Data content", value=st.session_state["Data"], height=400)
        fileName = 'data.xml' if st.session_state['DownloadButtonText'] == "Download full XML" else "data.json"
        st.download_button(st.session_state["DownloadButtonText"], data=st.session_state["Data"], file_name=fileName)

def show_json_in_expander(title, key):
    with st.expander(title):
        st.subheader(f"{title} Json")
        Methods.ShowJson(st.session_state[key])


if st.session_state['show_info']:
    if Methods.CheckDifferenceValues(providerUrl, assetId, consumerId, apiKey) or st.session_state['first_load']:
        process_request_catalog(providerUrl, assetId, consumerId, apiKey)

    if Methods.CheckSessionStates('RequestCatalogResponse'):
        Methods.ShowIds(st.session_state["RequestCatalogResponse"])
    
    if Methods.CheckSessionStates("CachedEdr"):
        with st.expander("Negotiation information", expanded=True):
            Methods.CreatePolicyTable()
            Methods.GetAuthCodeButton(st.session_state['CachedEdr'])
    
    if Methods.CheckSessionStates("auth_Code"):
        with st.expander("Autorisation code", expanded=True):
            Methods.CreateTable(st.session_state["auth_Code"], ["edc:endpoint"], "edc:authCode", "Auth Code")
            Methods.GetDataButton(st.session_state["auth_Code"])

    
    if st.session_state['show_catalog']:
        show_auth_code_and_data()
    
    if Methods.CheckSessionStates('auth_Code'):
        show_json_in_expander("Auth code", 'auth_Code')

    if Methods.CheckSessionStates("CachedEdr"):
        show_json_in_expander("Cached EDR", "CachedEdr")
    
    if st.session_state['show_catalog']:
        show_json_in_expander("Initiate EDR", "InitiateEdrResponse")

    if Methods.CheckSessionStates("RequestCatalogResponse"):
        show_json_in_expander("Request Catalog", "RequestCatalogResponse")
    
    Methods.CheckError()




