# Notifier Spring Boot Application

## How to create image:
	./gradlew clean build
	./gradlew jibDockerBuild


## Run on docker
	docker-compose up
	
## Test
	POST request URL: localhost:8080/add
	JSON Body:
	{
	"name" : "example",
	"email": "example@gmail.com"
}

## Check the data topic example :
		docker exec -it kafak_container_id bash
		cd opt/kafka/bin
		bash-4.4# kafka-console-consumer.sh --topic skill-test-info --bootstrap-server kafka:9092
		
		{"name":"example","email":"example@gmail.com"}
	
