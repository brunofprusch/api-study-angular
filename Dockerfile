FROM java:8
MAINTAINER brunoprusch@gmail.com

COPY /target/api-study-angular-deploy.jar /root/

WORKDIR /root

EXPOSE 8080

CMD ["java", "-jar", "api-study-angular-deploy.jar", "--spring.config.location=classpath:/docker.properties"]