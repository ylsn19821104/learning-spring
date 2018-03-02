FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD ./target/zipkin-server-1.0-SNAPSHOT.jar app.jar
#run bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.securiy.egd=file:/dev/./urandom","jar","/app.jar"]
EXPOSE 9411