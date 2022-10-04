FROM openjdk17
EXPOSE 8081
COPY /target/*.jar /usr/local/lib/spring.jar
ENTRYPOINT ["Java","-jar","usr/local/lib/spring.jar"]