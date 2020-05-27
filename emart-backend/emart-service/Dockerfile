# Emart Dockerfile for emart-service

# Author
MAINTAINER XuanHeLiu <liuxhe@cn.ibm.com>

FROM maven:3.3.9-jdk-8-alpine AS maven_build
USER root

# Emart Maven package
COPY . /tmp/emart-service
RUN cd /tmp/emart-service && mvn clean install -Dmaven.test.skip=true -Dmaven.javadoc.skip=true -Duser.timezone=UTC


# Travel Ready Jdk
FROM openjdk:8-jdk-alpine
COPY --from=maven_build /tmp/emart-service/target/emart-service-1.0-SNAPSHOT.jar /emart-service/emart-service.jar

# Expose port
EXPOSE 8000

# ENTRYPOINT
ENTRYPOINT java -Duser.timezone=UTC -jar /emart-service/emart-service.jar
