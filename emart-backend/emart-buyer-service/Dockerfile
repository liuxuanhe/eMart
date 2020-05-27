# Emart Dockerfile for emart-buyer-service

# Author
MAINTAINER XuanHeLiu <liuxhe@cn.ibm.com>

FROM maven:3.3.9-jdk-8-alpine AS maven_build
USER root

# Emart Maven package
COPY . /tmp/emart-buyer-service
RUN cd /tmp/emart-buyer-service && mvn clean install -Dmaven.test.skip=true -Dmaven.javadoc.skip=true -Duser.timezone=UTC


# Travel Ready Jdk
FROM openjdk:8-jdk-alpine
COPY --from=maven_build /tmp/emart-buyer-service/target/emart-buyer-service-1.0-SNAPSHOT.jar /emart-buyer-service/emart-buyer-service.jar

# Expose port
EXPOSE 8001

# ENTRYPOINT
ENTRYPOINT java -Duser.timezone=UTC -jar /emart-buyer-service/emart-buyer-service.jar
