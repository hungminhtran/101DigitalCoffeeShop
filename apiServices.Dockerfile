FROM ubuntu:22.04
RUN apt-get update && apt-get upgrade -y
RUN apt-get install openjdk-11-jdk -y
RUN apt install iputils-ping -y
RUN apt install dnsutils -y
ENV SPRING_CONFIG_NAME=application-dev
RUN apt install mysql-client -y
RUN apt install net-tools -y
ADD ./CoffeeShopServices/target/coffee-shop-services-0.0.1-SNAPSHOT.jar /coffee-shop-services.jar
ENTRYPOINT java -jar /coffee-shop-services.jar
