FROM maven:3.8.6-jdk-11
WORKDIR /home/abc
COPY src /home/abc/src
COPY pom.xml /home/abc
COPY testng.xml /home/abc
RUN mvn -f /home/abc/pom.xml clean test -DskipTests=true