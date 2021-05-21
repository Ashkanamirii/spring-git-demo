FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=target/*.jar

WORKDIR /myJavaDir

COPY ${JAR_FILE} application.jar

EXPOSE 8080

ENV MY_DB_USERNAME ="my data base username"
ENV MY_DB_PASSWORD ="my data base password"

ENTRYPOINT ["java","-jar","application.jar"]