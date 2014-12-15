camel-embedded
==============

Demo of using Apache Camel in embedded style.

Please install the following components to run the Demo:

  *  An Active MQ Server (I use the version apache-activemq-5.7.0).
  *  An Apache James Email-Server.
  *  An SOAP-UI Client to run the Tests.

Steps to run the demo:

1. Start the Activ-MQ server. The default Settings should be fine
2. Add the following Users to the James Email-Server:
    *  User: camel Password: camel
    *  User: camelsender Password: camel
3. Startup the War in an Tomcat Server.
4. Add the SOAP-UI projekt unter /src/test/resources to your soap-UI Projekt and call the services.
5. Have an look to the service logfiles.
