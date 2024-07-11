FROM openjdk:21 as builder

WORKDIR /app/msvc-order

COPY ./pom.xml /app
COPY ./msvc-order/.mvn ./.mvn
COPY ./msvc-order/mvnw .
COPY ./msvc-order/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./msvc-order/src ./src/
RUN ./mvnw clean package -DskipTests

FROM openjdk:21

WORKDIR /app
RUN mkdir ./logs

COPY --from=builder /app/msvc-order/target/msvc-order-0.0.1-SNAPSHOT.jar .

EXPOSE 8001

# ENTRYPOINT ["java","-jar","msvc-order-0.0.1-SNAPSHOT.jar"]
CMD ["java","-jar","msvc-order-0.0.1-SNAPSHOT.jar"]