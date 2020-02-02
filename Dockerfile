FROM openjdk:13
ADD target/spring-poc.jar spring-poc.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "spring-poc.jar"]