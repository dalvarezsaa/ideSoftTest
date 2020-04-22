FROM adoptopenjdk/openjdk11-openj9:latest

ARG JAR_FILE=target/IdeSoftTest_DA.jar

WORKDIR /opt/app

COPY ${JAR_FILE} IdeSoftTest_DA.jar

ENTRYPOINT ["java","-jar","IdeSoftTest_DA.jar"]