#FROM openjdk:8-jdk-alpine
#EXPOSE 8080
#ARG JAR_FILE=target/screening-api.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java", "-Djava.net.preferIPv4Stack=true", "-Dorg.owasp.esapi.resources=/data/config", "-Dspring.profiles.active=local-docker", "-DAPP_PROPS_FILE_PATH=/data/config/appconfig.properties", "-Dssl.SocketFactory.provider=com.ibm.jsse2.SSLSocketFactoryImpl", "-Djava.net.preferIPv4Stack=true", "-jar","/app.jar"]
FROM openjdk:8-jdk-alpine
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY target/app.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar