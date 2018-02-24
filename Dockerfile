FROM java:8
VOLUME /tmp
ADD . .
RUN ./mvnw clean package
RUN ls -la
EXPOSE 8080 8081
ENTRYPOINT ["java", "-jar", "target/top-hn-newcomers-0.0.1-SNAPSHOT.jar"]
