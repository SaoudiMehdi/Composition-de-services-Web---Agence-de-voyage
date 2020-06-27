FROM tomcat:jdk8

MAINTAINER ZAKARIA ZANATI



RUN apt-get update && apt-get install -y maven


COPY pom.xml /usr/local/service/pom.xml
COPY src /usr/local/service/src
WORKDIR /usr/local/service

RUN mvn package

COPY target/AgencyOffers.war /usr/local/tomcat/webapps/ROOT.war


EXPOSE 8080

CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]



