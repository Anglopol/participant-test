FROM adoptopenjdk/openjdk11:ubi
ADD target/demo-0.0.1-SNAPSHOT /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]