<p align="center">
  <a href="https://spring.io/" target="blank"><img src="./docs/img/spring-2.svg" width="400" alt="Spring Logo" /></a>
</p>

<p align="center">
Spring makes programming Java quicker, easier, and safer for everybody.
Spring’s focus on speed, simplicity, and productivity has made it the <a href="https://spring.io/why-spring" target="_blank">world's most popular</a> Java framework.
</p>

<p align="center">
<a target="_blank" href="https://github.com/bolicos/dragons-api/actions"><img src='https://github.com/bolicos/dragons-api/workflows/pipeline/badge.svg' alt="coverage badge" /></a>
<a target="_blank" href="https://github.com/bolicos/dragons-api/tags"><img src='https://img.shields.io/github/tag/bolicos/dragons-api.svg' alt='latest semver version' /></a>
<a target="_blank" href="https://github.com/bolicos/dragons-api/issues"><img src='https://img.shields.io/github/issues/bolicos/dragons-api.svg' alt='open issues badge' /></a>
<a target="_blank" href="https://github.com/bolicos/dragons-api/pulls"><img src='https://img.shields.io/github/issues-pr/bolicos/dragons-api.svg' alt='open pull requests badge' /></a>
<a target="_blank" href="https://github.com/bolicos/dragons-api"><img src='https://img.shields.io/github/languages/top/bolicos/dragons-api.svg' alt='top language' /></a>
<a target="_blank" href="hhttps://github.com/bolicos/dragons-api/tree/develop?tab=License-1-ov-file"><img src='https://img.shields.io/github/license/bolicos/dragons-api.svg' alt='github license' /></a>
<a target="_blank" href="https://github.com/bolicos/dragons-api"><img src='https://img.shields.io/github/languages/code-size/bolicos/dragons-api.svg' alt='code size in bytes' /></a>
<a target="_blank" href="https://github.com/bolicos/dragons-api"><img src='https://img.shields.io/github/repo-size/bolicos/dragons-api.svg' alt='repo size' /></a>
</p>

[//]: # (<img alt="GitHub branch check runs" src="https://img.shields.io/github/check-runs/bolicos/dragons-api/master">)
[//]: # (<img alt="GitHub deployments" src="https://img.shields.io/github/deployments/bolicos/dragons-api/assembly-dev">)
[//]: # (<img alt="Docker Image Size" src="https://img.shields.io/docker/image-size/bolicos/dragons-api">)

---

## Table of Contents
- [Introduction](#introduction)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Documentation](#documentation)
- [Environment Configuration](#environment-configuration)
- [Support](#support)
- [Stay in Touch](#stay-in-touch)
- [License](#license)

---

## Introduction
[Dragons API](https://github.com/bolicos/dragons-api) is a Java project built with the Spring Boot framework.
It serves as an example of an API repository, demonstrating best practices in API development using modern Java technologies.

## Installation
To get started with Dragons API, follow these steps:

```bash
# clone this repository:
git clone https://github.com/bolicos/dragons-api.git

# navigate into the project directory:
cd dragons-api

# build the project and install dependencies using Gradle:
./gradlew build
```

## Running the application
You can run the Dragons API in different modes:

```bash
# development mode
./gradlew bootRun --args='--spring.profiles.active=local'

# production mode
./gradlew bootRun--args='--spring.profiles.active=prod'

# docker mode
docker build -t bolicos/dragons-ap:latest .
```

## Testing
Dragons API comes with comprehensive test coverage. Use the following commands to run tests:

```bash
# run all tests:
./gradlew test

# run unit tests:
./gradlew unitTest

# run end-to-end (e2e) tests:
./gradlew integrationTest

# check all test coverage:
./gradlew test:coverage
```

## Documentation
API documentation is available through Swagger OpenAPI.
Access it by clicking [here](http://localhost:8000/api/docs) to explore the available endpoints.

## Environment Configuration
An example of the `.properties` file is provided within the project to help you configure your environment.

## Support
Top-tier support for Spring, Apache Tomcat®, and Java OpenJDK™, along with exclusive enterprise-ready features, 
components and extensions. It's available as part of [VMware Tanzu Platform](https://spring.io/support).

## Stay in touch
- Author - [Bolicos](https://github.com/bolicos)
- Website - [Linktree](https://linktr.ee/bolicos)
- Linkedin - [Perfil](https://linkedin.com/in/bolicos)

## License
Dragons API is licensed under the [MIT licensed](https://github.com/bolicos/dragons-api/tree/develop?tab=License-1-ov-file).