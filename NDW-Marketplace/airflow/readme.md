to install/update airflow run:
`helm upgrade --install airflow apache-airflow/airflow --namespace airflow --values value.yaml`


## image
For airflow we use a cutom image with some aditional package installed. The included docker file describes this immaged and should be build and available in the cluster. In the value.yaml file the name and tag of where this image is store can be changed 

## secrets
Make sure the airflow-secrets.yaml and the moblitect_cert_secret.yaml are propperly cahnged to reflect the correct credentails. 

The moblictec cert contains the certificate that is needed to connect and retrieve data from moblitec. 

The airflow-sercrets.yaml contains git credentials to connect to the git repository containing the dags that airflow should run. 

The url of the repo can be configure in de the value.yaml file. 
