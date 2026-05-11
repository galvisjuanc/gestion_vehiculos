FROM eclipse-temurin:25-jdk-alpine

WORKDIR /app

# 3. Copiamos el archivo JAR generado por Maven al contenedor
# Asegúrate de haber ejecutado 'mvn clean package' antes
COPY target/*.jar app.jar

# 4. Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]