Accelerate Your Spring Projects with This Spring Baseline Code
=

This is a baseline Spring project. It helps you accelerate the development of new Spring projects.

Maven Based Build
-
Maven is a the standardized build tool for this Spring project. It helps standardize the project directory structure, and also helps in managing the dependencies required for this project.

Maven Jetty Plugin
-
The Maven POM file in this project includes a Jetty plugin. This gives the developer the convenience to quickly run the WebApp within a Jetty container. It is also cnofigured for periodic refresh, which means the developer can edit a few lines of code and test immediately without needing a full WAR redeployment.

Spring MVC
-
This baseline code has configured Spring MVC using Annotations. Servelet 3.0 spec is used, which means it supports EL by default.

Logger Integration
-
The project integrates the Log4J logging library and provides as default configuration file for the logger. 

Design Principles
-
1. Prefer stable versions of the frameworks, libraries and other dependencies, instead of the latest and greatest versions. The key benefit of doing this is that this baseline code stays "Enterprise Ready"
2. Keep third party binary dependencies out of your source tree as much as possible.
3. Stick to the standard build structure of Maven.
4. Developers go thru a "Edit-Build-Run-Test" cycle a zillion times a day. In the interest of developer productivity, we have to make this cycle very efficient. Make it less painful for the developers to make quick edits and test them, without painful deployment steps.
5. Separate configuration from business logic. Provide a standard way to "externalize" configuration and refernce it in your business logic.
