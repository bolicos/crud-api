DEFAULT_GOAL := help

.PHONY: help
help: ## Show this help
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

build: ## Build application
	./gradlew clean build --no-daemon

unit-test: ## Execute application unit tests
	./gradlew clean test

jar: ## Generate .jar file
	./gradlew clean bootJar

docker-image: ## Generate docker image
	docker build  -t "bolicos/dragons-api:latest" -f Dockerfile .

docker-run: ## Run docker image
	docker run -d -e "SPRING_PROFILES_ACTIVE=local" -p 8000:8000 --name "api" -t "bolicos/dragons-api:latest"