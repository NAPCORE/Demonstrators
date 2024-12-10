consumerIdStaticUrl = "/management/v2/catalog/request"
providerStaticUrl = "/api/v1/dsp"
edrStaticUrl = "/management/edrs"
headers = {
    "X-Api-Key": "[[apiKey]]",
    "Content-Type": "application/json" 
}
firstJsonLocation = "JsonRequests/RequestCatalog.json"
secondJsonLocation = "JsonRequests/InitiateEdr.json"

#Variables to set
providerUrl = ""
assetId = ""
consumerId = ""
apiKey = ""
