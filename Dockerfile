FROM java:8
EXPOSE 5557
VOLUME /tmp
ADD /target/myFirstSparkApp-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-jar", "/app.jar"]