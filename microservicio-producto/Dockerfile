# Usar una imagen base de Java 17
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el JAR generado por el microservicio
COPY target/*.jar app.jar

# Exponer el puerto que usa el microservicio
EXPOSE 8082

# Comando para ejecutar el JAR
CMD ["java", "-jar", "app.jar"]