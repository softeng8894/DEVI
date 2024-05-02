FROM maven:3.8.6-jdk-11
WORKDIR /home/abc
COPY src /home/mahi/src
COPY pom.xml /home/mahi
COPY testng.xml /home/mahi
RUN mvn -f /home/mahi/pom.xml clean test -DskipTests=true