# Emart Dockerfile for emart-eureka-server

# Author
MAINTAINER XuanHeLiu <liuxhe@cn.ibm.com>

FROM maven:3.3.9-jdk-8-alpine AS maven_build
USER root

# Emart Maven package
COPY . /tmp/emart-eureka-server
RUN cd /tmp/emart-eureka-server && mvn clean install -Dmaven.test.skip=true -Dmaven.javadoc.skip=true -Duser.timezone=UTC


# Travel Ready Jdk
FROM openjdk:8-jdk-alpine
COPY --from=maven_build /tmp/emart-eureka-server/target/emart-eureka-server-1.0-SNAPSHOT.jar /emart-eureka-server/emart-eureka-server.jar

# Expose port
EXPOSE 8003

# ENTRYPOINT
ENTRYPOINT java -Duser.timezone=UTC -jar /emart-eureka-server/emart-eureka-server.jar
