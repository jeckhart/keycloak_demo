[![Build Status](https://travis-ci.org/SUMGlobal/keycloak_demo.svg?branch=master)](https://travis-ci.org/SUMGlobal/keycloak_demo)
# Keycloak/Wildfly/Angular Example
When complete, I hope to show:
* working keycloak server
    * public web app realm
    * bearer token service realm
    * LDAP user federation
    * themed login/account pages
    * user attribute mapping
* sample angular application
    * keycloak login
    * call to sample services
* keycloak protected JEE application
    * secure url - web.xml
    * secure ejb layer
    * access to keycloak access token and resources
* Added nginx ssl reverse proxy
    * keycloak is accessed as https://172.16.0.100/auth
    * serenity services are accessed as https://172.16.0.100/serenity

### Setup
* startup vagrant vm
    * follow [vm-keycloak README.md] to setup vm
    * start vm
* build war files `gradle clean build`
    * creates `serenity/build/libs/serenity.war`
* copy war files to vm for deployment
    * `cp serenity/build/libs/serenity.war vm-keycloak/shared`
    * `cd vm-keycloak; vagrant ssh`
    * `sudo -u wildfly cp /shared/*.war /opt/jboss/wildfly/standalone/deployments`
    * `sudo service keycloak start`
    * `sudo service wildfly start`
* start cortex application
    * `cd cortex`
    * `npm install`
    * `bower install`
    * `gulp serve`
    * will launch app in browser
    * uses gulp/browser-sync

### Running
* login to [keycloak] with default admin/admin credentials
 * NOTE: you will need to set another admin password

---
[keycloak]:https://172.16.0.100:9080/auth
[vm-keycloak README.md]:vm-keycloak/README.md
