# NTM Metadata registry

This folder contains the configuration files for the NTM medata registry. No changes where made to the code so only the config files have been provided. 

## Backend
All 3 parts of the metadata registry where deployed to k8s. A ingress, service and deployment.yaml where created to deploy the backend to k8s.

## Frontend
For the frontend a ingress, service and deployment.yaml where also created. But for the frontend also the nginx config was changd. A route was added to route api trafic to the backend. 


## Database
The databae was deployed using the default postgres helmchart using the provided value.yaml to change the credentials. 




