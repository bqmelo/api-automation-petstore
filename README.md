# api-automation-petstore
The purpose of the project is to test the OpenApi [Swagger PetStore](https://petstore.swagger.io/) using Docker Compose, Docker, Gradle, Java, RestAssured and CircleCi as a CI.

Folder structure:

```
.circleci/
    config.yml
graddle/

app/
    build/
        classes/
        generated/
        reports/
        resources/
        test-results/
        tmp/
    src/
        test/
            java/
                api.automation.pet.store/
                    steps/
                        PetStepDefinitions
                        UserStepDefinitions
                    support/
                        client/
                            PetClient
                            UserClient
                        config/
                            ConfigManager
                            RequestConfig
                            ServerConfig
                        domain/
                            Pet
                            User
                CucumberRunner
            resources/
                features/
                    pet.feature
                    user.feature
                properties/
                    circleci.properties
                    local.properties
        build.gradle
        lombok.config

gradle/
README.md
```

### Project details

- Language: Java
- Package manager: Gradle
- Testing Tools: Cucumber, RestAssured
- Reports: Cucumber report and Junit
- CI platform: CircleCi

#### Scenarios covered
- Create user:
  - The POST user **must** be working, as the user should be able to create a new user in the app. It prevents sharing users in the PetStore.

- Get user:
  - This one is important to verify if the user created is there.

- Create pet:
  - In the PetStore, I suppose the main “job” is around pets. So the user should be able to create a pet.

- Update user:
  - As one of the properties in the Pet JSON is `status`, it is important for the user tracking which pet is available, pending, or sold. So, the user should be able to update this property in the PetStore.

- Get Pet by status:
  - The user should be able to filter the Pets by status.

#### Reports

- CI:
  - In the `Test` tab you will find if something went wrong
  - In the `Artifacts` tab you will find the reports


- Local after run the project: `app/build/reports/feature.html`

The folder report and the report itself are generated in every run.


## Continuous Integration with CircleCI
Continuous integration improves team productivity, efficiency, confidence, and happiness. Find problems and solve them quickly. Release higher quality, more stable products.


CircleCI is a cloud-based CI/CD tool that automates installation and delivery procedures. Since it is a cloud-based CI/CD tool, it eliminates the redundancy of a dedicated server and cuts down the cost of maintenance of a constant local server host.

See more about [CircleCi](https://circleci.com/docs/).

The project is integrated with CircleCI:

- CircleCI Project: [api-automation-petstore](https://app.circleci.com/pipelines/github/bqmelo/api-automation-petstore?branch=main&filter=all)

#### Reports

You can find the reports for each CI run by:

- Acessing the build run you desire
- In the `Test` tab you will find if something went wrong
- In the `Artifacts` tab you will find the Cucumber reports

## Project Prerequisites

Requirements to run the project locally:

- Gradle 7.4.2
- Java 11
- Docker Compose


### Running project locally

After install all the dependencies, you will need run the following commands:

#### Start Swagger PetStore locally.

The command below will start running the PetStore in http://localhost:3306.

> **NOTE:** You don't need to start the PetStore container if you will only run the tests. It will be useful if you need check the endpoints, responses, etc.

- Run the command inside root folder `~/api-automation-petstore`.

```
docker-compose up
```

#### Run the tests

To run the tests you can use 2 commands:

- The first one will run the tests but it is **mandatory** have PetStore container running locally. Run the command inside root folder `~/api-automation-petstore`.

```
./gradlew test
```

- The other alternative is start the container, run the tests and stop the automatically. For this one it will not necessary have the PetStore container running locally. Run the command inside root folder `~/api-automation-petstore`

```
./gradlew localTest
```

# Next Steps
1. Find a solution in CircleCi to use the `execute shell` for executing a .bash in the project, or execute the `Calliope POST request` directly in config.yml for sending the test results to the Calliope platform.
2. Refine the reports and specs in code to get more clear results.
3. Integrate project in another CI to get knowledge in other platforms.
