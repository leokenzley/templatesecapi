# Use uma imagem base do OpenJDK 21
FROM openjdk:21-jdk

# Adicione um volume apontando para /tmp
VOLUME /tmp

# Adicione o jar da aplicação
ARG JAR_FILE=target/openapiswagger-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

# Exponha a porta que a aplicação irá rodar
EXPOSE 8080

# Execute a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]