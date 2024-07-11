E-commerce Platform

Este proyecto consiste en una plataforma de comercio electrónico simplificada con microservicios para la gestión de catálogo de productos y gestión de pedidos.

## Microservicios

1. **msvc-order**: Servicio de gestión de pedidos.
2. **msvc-product**: Servicio de catálogo de productos.

## Requisitos

- Docker
- Docker Compose
- Java 21 o superior
- Maven

## Instalación y Ejecución

### 1. Clonar el repositorio

```sh
git clone https://github.com/angeledugo/order-app
cd order-app
cd msvc-order
mvn clean package -DskipTests
cd ../msvc-product
mvn clean package -DskipTests
cd ..
docker build -t order:v1 . -f .\msvc-order\Dockerfile
docker build -t product:v1 . -f .\msvc-product\Dockerfile
docker network create ecommerce-network
docker run -p 8001:8001 --rm -d --network ecommerce-network --name msvc-product:v1 product  
docker run -p 8002:8002 --rm -d --network ecommerce-network --name msvc-order:v1 order  