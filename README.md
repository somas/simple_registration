# simple_registration

Uses
- Java 8
- Spring
- HSQLDB
- Gradle

# Running in Embedded Mode (recommended easy to run)
Step 1: Install Java JDK 1.8 and above *

    -Install the security policy jars into ${java.home}/jre/lib/security/. 

Step 2: Run in embedded tomcat
``` gradle
Command Prompt
cmd> gradlew clean build war tomcatRun
```

Step 3: http://localhost:9080/portal

Step 4: Code is running using HSQLDB, results can be found in the following location

```HSQLDB
<app_home>\src\main\resources\db\masterdb.log
```

# Running in Standalone mode - Tomcat 8
Step 1: Modify build.gradle to add dependencies

``` gradle
	providedCompile 'org.slf4j:jcl-over-slf4j:1.7.6'
	providedCompile 'javax.servlet:javax.servlet-api:3.0.1'
	
	to
	
	compile 'org.slf4j:jcl-over-slf4j:1.7.6'
	compile 'javax.servlet:javax.servlet-api:3.0.1'
```

Step 2: Build war
``` gradle
Command Prompt
cmd> gradlew clean build war
```

Step 3: Copy to webapps folder of tomcat and run <tomcat_home>\bin\catalina start

Step 4: http://{hostname}/portal

Step 5: Code is running using HSQLDB, results can be found in the following location

```HSQLDB
<tomcat_home>\webapps\portal\WEB-INF\classes\db\masterdb.log
```
