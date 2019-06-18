FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN

WORKDIR /tmp/
COPY pom.xml /tmp/
COPY src /tmp/src/
RUN mvn -B clean install -DskipTests

FROM tomcat:9.0-jre8-alpine

COPY --from=MAVEN_TOOL_CHAIN /tmp/target/demoserver-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/demoserver-0.0.1-SNAPSHOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]