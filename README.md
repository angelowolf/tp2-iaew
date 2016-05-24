OUTPUT DE CREACION KEYSTORE
===================================================

$ keytool -genkey -alias tomcat -keyalg RSA

Enter keystore password: adminroot

Re-enter new password: adminroot

What is your first and last name?  Wolf Carranza

What is the name of your organizational unit? IAEW

What is the name of your organization? UTN FRC

What is the name of your City or Locality? Cordoba

What is the name of your State or Province? Cordoba

What is the two-letter country code for this unit? AR

Is CN=Wolf Carranza, OU=IAEW, O=UTN FRC, L=Cordoba, ST=Cordoba, C=AR correct? yes

Enter key password for <tomcat>: adminroot
   

		
Tomcat/conf/tomcat-users.xml		
=========================================================

\<role rolename="admin"/\>
\<user username="adminroot" password="adminroot" roles="admin-gui,manager-gui,manager-script,admin"/\>  


Tomcat/conf/server.xml
=========================================================

\<Connector port="8443" protocol="HTTP/1.1" SSLEnabled="true"
   maxThreads="150" scheme="https" secure="true" clientAuth="false"
   sslProtocol="TLS" keystoreFile="\c:\.keystore" keystorePass="adminroot"/\>

