FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /usr/app/

COPY target/*.jar app.jar

ENV DB_HOST="localhost"
ENV DB_PORT="5432"
ENV DB_NAME="planner_db"
ENV DB_USER="postgres"
ENV DB_PASS="postgres"

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]