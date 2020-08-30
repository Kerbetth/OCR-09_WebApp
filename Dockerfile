FROM openjdk:14
ADD build/libs/mediscreen-client.jar mediscreen-client.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "mediscreen-client.jar"]
