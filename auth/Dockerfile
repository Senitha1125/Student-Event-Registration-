FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN cd auth && ../mvnw clean package -DskipTests

EXPOSE 8080




CMD ["sh", "-c", "java -jar auth/target/*.jar"]











