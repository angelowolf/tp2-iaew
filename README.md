CREACION KEYSTORE
===================================================

$ keytool -genkey -alias tomcat -keyalg RSA
Enter keystore password: adminroot
Re-enter new password: adminroot
What is your first and last name?
  [Unknown]:  Wolf Carranza
What is the name of your organizational unit?
  [Unknown]:  IAEW
What is the name of your organization?
  [Unknown]:  UTN FRC
What is the name of your City or Locality?
  [Unknown]:  Cordoba
What is the name of your State or Province?
  [Unknown]:  Cordoba
What is the two-letter country code for this unit?
  [Unknown]:  AR
Is CN=Wolf Carranza, OU=IAEW, O=UTN FRC, L=Cordoba, ST=Cordoba, C=AR correct?
  [no]:  yes

Enter key password for <tomcat>
        (RETURN if same as keystore password): adminroot

		
Tomcat/conf/tomcat-users.xml		
=========================================================
<role rolename="admin"/>   
<user username="adminroot" password="adminroot" roles="admin-gui,manager-gui,manager-script,admin"/>  


Tomcat/conf/server.xml
=========================================================
<Connector port="8443" protocol="HTTP/1.1" SSLEnabled="true"
   maxThreads="150" scheme="https" secure="true" clientAuth="false"
   sslProtocol="TLS" keystoreFile="\c:\.keystore" keystorePass="adminroot"/>

