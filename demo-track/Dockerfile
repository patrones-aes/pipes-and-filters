# Utiliza una imagen de Gradle como base
FROM gradle:8.6.0-jdk17-alpine AS build

# Establece el directorio de trabajo
WORKDIR /tmp

COPY --chown=gradle:gradle . .

RUN gradle build --no-daemon 

# Utiliza una imagen de Java como base
FROM openjdk:17 AS run

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR de tu aplicación al contenedor
# COPY /home/felipe/dockerimages/pipeone.jar pipeone.jar
COPY --from=build /tmp/build/libs/*.jar pipeone.jar

# Expone el puerto en el que tu aplicación escucha
EXPOSE 8080

ENTRYPOINT ["java","-jar","pipeone.jar"]
