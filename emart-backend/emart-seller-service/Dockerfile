# Emart Dockerfile for emart-seller-service

# Author
MAINTAINER XuanHeLiu <liuxhe@cn.ibm.com>

FROM maven:3.3.9-jdk-8-alpine AS maven_build
USER root

# Emart Maven package
COPY . /tmp/emart-seller-service
RUN cd /tmp/emart-seller-service && mvn clean install -Dmaven.test.skip=true -Dmaven.javadoc.skip=true -Duser.timezone=UTC


# Travel Ready Jdk
FROM openjdk:8-jdk-alpine
COPY --from=maven_build /tmp/emart-seller-service/target/emart-seller-service-1.0-SNAPSHOT.jar /emart-seller-service/emart-seller-service.jar

# Expose port
EXPOSE 8002

# ENTRYPOINT
ENTRYPOINT java -Duser.timezone=UTC -jar /emart-seller-service/emart-seller-service.jar
