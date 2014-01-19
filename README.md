Springboard: Accelerate Your Spring Development 
=

This is a baseline Spring project that helps you accelerate the development of new Spring projects. Here is what we planned to achieve with this baseline project:

+ Single-click, repeatable build process using Maven
+ A working Baseline of Spring MVC to Develop Web GUI Applications
+ A working Baseline of JSON REST APIs
+ A working Baseline of XML REST APIs
+ Integrated Log4J Logger
+ Integrated Jetty Plugin to help accelerate your "dev-build-test" cycles

Version Summary
-
These are the versions of the various libraries, frameworks, dependencies used by this baseline project:
Maven: 3.0
Spring: 3.1.1.RELEASE
Jetty: 9.1.1
Jackson: 1.9.12 

Maven Based Build
-
In all mature development projects, the build process must be highly reproducible. A reproducible build makes it so much easier to rapidly onboard new developers and team members. So this baseline code uses Maven as it's standardized build tool. Maven offers a standardize project directory structure, and also helps in managing the dependencies required for the project.

To build this project from the command line:
`$ maven clean install`

Maven Jetty Plugin
-
Development happens incrementally. Developers often change just a few lines of code, and then want to quickly redeploy the code to test their changes. If this Edit-Build-Deploy-Test cycle is painful, then it slows down development. So this Maven project includes a Jetty Plugin. This let's the developer to quickly run the Web App within a Jetty Container using this command:
`$ mvn jetty:run`

Moreover, the Jetty Plugin is also configured for a "periodic refresh", which means the developer can edit just a few lines of code and test it immediately without needing a full WAR redeployment.

The Web App Archetype
-
This project adheres to the standard Web App archetype offered by Maven. So seasoned Maven developers can already relate to the project directory structure.

In fact, the source tree was first created using something like this:
`$ mvn archetype:generate -DgroupId=com.mindstix -DartifactId=sample -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false`

The Web Deployment Descriptor (web.xml) can be found under:
`src/main/webapp/WEB-INF/web.xml`

The web.xml is pretty lightweight here. It includes a single servlet (Spring's Dispatcher Servlet) mapped to the root path. This is where Spring's Front-Controller kicks in. 

Spring MVC
-
The most common requirement in Web App development is to support the standard MVC Model: Inbound HTTP requests get mapped to a specific Controller, and then, the Controller decides to render a specific View (JSP Page). We use Spring MVC to facilitate this.

Spring MVC adopts a front-controller pattern (that's the Dispatcher Servlet we included in our web.xml). Spring-MVC's Request Mapping capabilities are responsible to map a specific inbound HTTP URL request to a specific Controller class/method.

Annotation Powered
-
Annotations are the preferred way to setup the component wiring, as this avoids the XML bloat in your Spring configuration. This baseline code is hence configured to use Spring MVC using Annotations. To keep the size of the Spring XML to a minimum, we've enabled the "component scan" in the Spring XML which should automatically sniff out our Controller classes automatically based on the Annotations.

REST API
-
Another common requirement is to expose a REST-JSON API from your Web App. This entails several aspects:
+ Mapping REST URLs to Specific Controllers
+ Extracting Input Parameters from the URL Segments
+ Generating a JSON Response to the Client

We enable this using the following in our Spring configuration:
`<mvc:annotation-driven />`

This enables you to define RESTful Controllers by using the @Controller annotations on those classes. The @RequestMapping annotations let you map specific URLs to specific methods within the Controller class. 

DTOs for the REST API
-
The "data model" for the JSON objects is defined in the "DTO" package. These are simply Java beans which get serialized to JSON. Your Controller classes can return the "object tree" of these DTO objects, and Spring takes care of the rest of the job (Traversing the DTO Object Tree to generate Serialized JSON). We've included a dependency to the Jackson JSON Mapper to facilitate this.

Invoking the REST API for Testing
-
Easiest way is to use command line CURL. The client sends the datatype that it "accepts". The ContentNegotiation mechanism automatically determines whether to convert the REST resource to JSON or XML based on the "Accept" header received from the client.

To receive an XML response from the REST API:
`curl -i -H "Accept: application/xml" -X GET http://localhost:8080/sample/api/v1/employee`

To receive a JSON response from the REST API:
`curl -i -H "Accept: application/json" -X GET http://localhost:8080/sample/api/v1/employee`

Logger Integration
-
The project integrates the Log4J logging library and provides as default configuration file for the logger. 

Design Principles
=
1. Prefer stable versions of the frameworks, libraries and other dependencies, instead of the latest and greatest versions. The key benefit of doing this is that this baseline code stays "Enterprise Ready"

2. Keep third party binary dependencies out of your source tree as much as possible.

3. Stick to the standard build structure of Maven.

4. Developers go thru a "Edit-Build-Run-Test" cycle a zillion times a day. In the interest of developer productivity, we have to make this cycle very efficient. Make it less painful for the developers to make quick edits and test them, without painful deployment steps.

5. Separate configuration from business logic. Provide a standard way to "externalize" configuration and reference it in your business logic.
