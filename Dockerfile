FROM ubuntu:latest
LABEL authors="Abhilasha"
ENTRYPOINT ["top", "-b"]
RUN mvn clean install -DskipTests=true


