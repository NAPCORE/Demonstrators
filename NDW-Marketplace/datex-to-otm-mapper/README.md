## Introduction
This code maps the Datex2 model, as used by Mobilithek, to OTM5 model. It will fetch the XML file from the data service, map it and output it in JSON file back to the data service.

## Getting Started
To run the code you will first need to have Java installed.
You can run the code at App.java. You will first need to build the project in VS Code.

## Deployment
The Docker image is available in the napcoredataspace container registry in Azure. To update the image, you will first need to make a new jar of the Java project (Datex2-to-OTM-mapper.jar). The Dockerfile will use this new jar. To push the new dockerfile you need to have Azure CLI installed and Docker Desktop. Then you need to run:
```
docker build --tag=napcoredataspace.azurecr.io/datex2-to-otm-mapper --no-cache . 
az login
az acr login --name napcoredataspace
docker push napcoredataspace.azurecr.io/datex2-to-otm-mapper
```

You can check if the new version of the Docker image updated correctly in the Azure Portal at the napcoredataspace container registry > Services > Repositories > datex2-to-otm-mapper.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
