# Java Web Application using Embedded Tomcat

# Team 6 : FluffyCorp
Branche de code à regarder : propre

Chemin du .war : ./target/embeddedTomcatSample.war

Rapport : .....

Video de presentation : ....


## Prerequisites

* Download Maven : 
http://mirrors.standaloneinstaller.com/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip

* Add to the path environement :
Linux : export PATH=$PATH:<path_to_maven>/bin
Windows : Setting global environment variables add the "<path_to_maven>\bin" to the variable "Path"

## Once it's done

* Go into your project directory and run :
> mvn package
* Then to start the server :
> sh target/bin/webapp (on Linux) 
OR 
> target/bin/webapp.bat (on Windows)

## Reference

https://devcenter.heroku.com/articles/create-a-java-web-application-using-embedded-tomcat
