FROM openjdk:21 as builder

WORKDIR /app/msvc-product

COPY ./pom.xml /app
COPY ./msvc-product/.mvn ./.mvn
COPY ./msvc-product/mvnw .
COPY ./msvc-product/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./msvc-product/src ./src/
RUN ./mvnw clean package -DskipTests

FROM openjdk:21

WORKDIR /app
RUN mkdir ./logs

COPY --from=builder /app/msvc-product/target/msvc-product-0.0.1-SNAPSHOT.jar .

EXPOSE 8001

# ENTRYPOINT ["java","-jar","msvc-product-0.0.1-SNAPSHOT.jar"]
CMD ["java","-jar","msvc-product-0.0.1-SNAPSHOT.jar"]