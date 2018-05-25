FROM tomcat:8.5-jre9
MAINTAINER tristan3fish@hotmail.com

#Remove other unused webapps
RUN rm -rf ${CATALINA_HOME}/webapps/*

#copy over war file calling it ROOT so it is the main app
COPY ./target/*.war ${CATALINA_HOME}/webapps/ROOT.war