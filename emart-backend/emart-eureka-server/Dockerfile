# Emart Dockerfile for emart-eureka-server

# Add Maintainer Info
MAINTAINER XuanHeLiu <liuxhe@cn.ibm.com>

# Set Env
ENV TZ Asia/Shanghai

# The application's jar file
ARG JAR_FILE=target/emart-eureka-server-1.0-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file
 ENTRYPOINT ["java","-jar","/app.jar"]