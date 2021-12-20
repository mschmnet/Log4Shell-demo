FROM maven:3.3-jdk-8 as build
RUN mkdir /app
WORKDIR /app
COPY . /app
RUN mvn clean package

FROM python:3.11.0a3-slim

EXPOSE 8888 
RUN mkdir -p /app
WORKDIR /app
COPY --from=build /app/target/classes/* /app/
CMD python3 -m http.server 8888
