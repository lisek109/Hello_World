FROM tomcat:jdk8-openjdk

COPY target/Hello_World-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

CMD ["catalina.sh run"]

