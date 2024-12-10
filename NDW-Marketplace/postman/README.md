## Getting Started Guide

This postman collection demonstrate the API calls towards end-to-end data exchange journey through the postman REST client.

### Components included in the collection:
- Provider
- Consumer
- Managed Identity Wallet
- NTM Metadata Registry
- Authentication
- Portal Backend


### Steps to Proceed

#### tx-umbrella Collection
- Setup up [Postman client](https://www.postman.com/downloads)

- Import the [tx-umbrella collection](./tx-umbrella.postman_collection.json)

- Configure the following environment variables from the variables tab inside the root directory.
## Parameters


| Name                    | Description                            | Example Value                |
|-------------------------|----------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ***providerUrl***      | The EDC provider controlplane Url             |   [https://dataprovider-controlplane.d37c3234d8454420babf.westeurope.aksapp.io](https://dataprovider-controlplane.d37c3234d8454420babf.westeurope.aksapp.io)                                                                                                                                                                                               |
| ***consumerUrl***      | The EDC consumer controlplane Url             | [http://dataconsumer-1-controlplane.d37c3234d8454420babf.westeurope.aksapp.io](http://dataconsumer-1-controlplane.d37c3234d8454420babf.westeurope.aksapp.io)                                                                                                                                                                                                                                                                                                                          |
| ***providerBpn***      | Provider's Business Partner Number (BPN)      |  BPNL000000000NDW                                                                                                                                                                                                                                                                         |
| ***consumerBpn***      | Consumer's Business Partner Number (BPN)      | BPNLCGI000000000   |
| ***assetId***          | The asset Id of the data                      | urn:uuid:a2fea4a0-6ffe-4403-9233-614a1c4c2573   |
| ***submodelServer***   | The provider's backend data service endpoint  | [https://data-service.d37c3234d8454420babf.westeurope.aksapp.io/api](https://data-service.d37c3234d8454420babf.westeurope.aksapp.io/api)   |
| ***ntmBackendUrl***    | The NTM Metadata registry backend Url | [https://ntm-backend.d37c3234d8454420babf.westeurope.aksapp.io](https://ntm-backend.d37c3234d8454420babf.westeurope.aksapp.io)   |
| ***publicationId***    | The data publication Id stored in the NTM backend registry | efdf4ed7-7c74-49da-a3c3-16fb411provider24e06   |
| ***providerApiKey***   | The API Key to authenticate against the provider EDC | TEST2   |
| ***consumerApiKey***   | The API Key to authenticate against the consumer EDC | TEST1   |
| ***miwUrl***           | The Managed Identity Wallet (MIW) Url | [https://managed-identity-wallets.d37c3234d8454420babf.westeurope.aksapp.io](https://managed-identity-wallets.d37c3234d8454420babf.westeurope.aksapp.io)   |


>Note: Apart from the above parameters, there are some other variables that are not required to set and populate programmatically.
