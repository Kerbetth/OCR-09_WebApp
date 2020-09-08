FROM openjdk:14
ADD target/mediscreen_webapp-1.jar mediscreen_webapp-1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "mediscreen_webapp-1.jar"]
