# cnj-persistence-sql-backend-spring

Cloud native Spring Boot backend using Spring Data JPA to persist its domain model in a PostgreSQL database.

## Status

![Build Status](https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiS2kvd1p0cXVWM2tEVzF6YTlYLzBOL1AwOXpQQzE5Tzd5eVdiSE5CeVpNWi8xdzBzampkK3JoczhxVUp1RVdFRFhwNTdhMFhiLzBXby9GN29xb3YydUdVPSIsIml2UGFyYW1ldGVyU3BlYyI6ImZMVk1WdlBKSlg0dXRDNmEiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=main)

## Release information

Check [changelog](changelog.md) for latest version and release information.

## Docker Pull Command

`docker pull docker.cloudtrain.aws.msgoat.eu/cloudtrain/cnj-persistence-sql-backend-spring`

## Synopsis

This showcase demonstrates
* how to integrate relational databases in Spring Boot application using Spring Data over JPA
* how to create evolve relational database schemas using FlyWay 

## Database schema management

The SQL files to create and update the database schema are part of the application code at `/src/main/resources/db.migration`.
Just by adding FlyWay as a dependency to the application's POM, Spring Boot's autoconfiguration feature automatically
triggers a FlyWay run when the application is started.

## HOW-TO build this application locally

If all prerequisites are met, just run the following Maven command in the project folder:

```shell 
mvn clean verify -P pre-commit-stage
```

Build results: a Docker image containing the showcase application.

## HOW-TO start and stop this showcase locally

In order to run the whole showcase locally, just run the following docker commands in the project folder:

```shell 
docker compose up -d
docker compose logs -f 
```

Press `Ctlr+c` to stop tailing the container logs and run the following docker command to stop the showcase:

```shell 
docker compose down
```

## HOW-TO demo this showcase

The showcase application will be accessible:
* locally via `http://localhost:38080`
* remotely via `https://train2023-dev.k8s.cloudtrain.aws.msgoat.eu/cloudtrain/cnj-persistence-sql-backend-spring` (if the training cluster is up and running)

The OpenAPI specification of the exposed REST API is available at URI `/openapi`.
