# Etapa de build
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Cria diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Compila o projeto e gera o JAR
RUN mvn clean package -DskipTests

# Etapa de execução
FROM eclipse-temurin:21-jdk

# Define diretório de trabalho
WORKDIR /app

# Expõe a porta 8080 (ou a que você usa)
EXPOSE 8080

# Copia o JAR gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Comando de execução
ENTRYPOINT ["java", "-jar", "app.jar"]