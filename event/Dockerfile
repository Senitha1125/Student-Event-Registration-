FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN cd event && ../mvnw clean package -DskipTests

EXPOSE 8080


CMD ["sh", "-c", "java -jar event/target/*.jar"]












