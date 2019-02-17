FROM openjdk:8-alpine

# Required for starting application up.
RUN apk update && apk add bash

COPY target/dashboard-0.1.0.jar $PROJECT_HOME/dashboard-0.1.0.jar
CMD ["java", "-Dspring.data.mongodb.uri=mongodb://mongo_dashboard:27017/demo","-Djava.security.egd=file:/dev/./urandom","-jar","./dashboard-0.1.0.jar"]
