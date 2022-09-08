FROM tomcat

MAINTAINER Tomasz Lisowski "lis109@wp.pl"

WORKDIR /usr/local/bin/

COPY target/Hello_World-1.0-SNAPSHOT.war .

CMD ["bin/bash"]

