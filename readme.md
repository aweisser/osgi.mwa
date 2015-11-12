# Modular Web App (MWA)

In this project I study what it feels like building a really modular webapp out of finegrained bundles with clear interfaces, high cohesion and low coupling.

## How to get there?
1. :white_check_mark: (Branch `boilerplate`) Provide a simple basic project setup based on Maven and Gulp, where I'm able to very simply build my OSGi bundles and deploy them with all their depdendencies directly to a local OSGi runtime.
1. :white_check_mark: (Branch `mwa.web`) Assemble a bundle that serves static web resources (index.html ...) and a simple Servlet uising an HttpService bundle
1. Provide a mechanism where endpoints can register themself at the web module dynamically. 
1. Implement a simple dispatcher that is aware of the presence of registered endpoints
1. Make the GUI send a XHR request that the mapped controller should answer to.
1. Make the GUI auto state the availability of a backend service (aka "feature"). If an HTTP 503 is returned the "feature" is not available.
1. ...


##Prerequisits
* JDK >= 1.7
* Maven 3 - https://maven.apache.org/
* npm - https://www.npmjs.com/

##Installation
    npm install
    gulp make

##Starting the OSGi container
    gulp felix:up
    
##Open the Web-Management Console:
    http://localhost:8080/system/console (admin/admin)

## Appendix

###Usefull debug commands:
    inspect cap service

###Bundles
    http://repo1.maven.org/maven2/org/apache/felix/
    
### Git
    git tag (list tags)
    git tag -d <name> (remove a tag)
    git push origin --tags (push tag to remote)
    
### Inspiring Sources
    https://ekkescorner.wordpress.com/2008/09/24/logging-in-osgi-enterprise-applications-part-1/
    
### Findings as I proceed
* iPojo seems to have problems instantiating a Groovy-Class. If you rename the file "FriendlyGreeter.java" to "FriendlyGreeter.groovy" the starting and stopping methods are not called any more. =(
* To serve static web resources outside a bundle one have to provide an customized implementation of HttpContext with an appropriate getResource(String) method. 