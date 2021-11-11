### Project Description ###

This is an example of Web UI testing framework using Selenium.

System Under Test (SUT): NASA official website - https://www.nasa.gov/. 

List of main tools and libraries used:

- Maven
- Junit5
- Selenium-Java
- WebDriverManager
- Allure-Junit5
- AssertJ
- Allure-AssertJ
- Jenkins


## 1. Prerequisites
Before running tests make sure you have installed:
- JDK 11: https://openjdk.java.net/projects/jdk/11/
- Maven 3.6.3 and above: https://maven.apache.org/download.cgi
- Chrome / Firefox browser
- [Optional] Allure 2.15.0 and above to manually generate reports. See https://docs.qameta.io/allure/ \
  for installation guidance

**NOTE:** You don't need to install any WebDriver version manually, the process is fully automated by **WebDriverManager**.

## 2. Running tests locally


#### 2.1 Load the project from the GitHub
Project URL: https://github.com/in7hesky/java-selenium-allure-framework
For example, you may load the project using the command line:
```
git clone git@github.com:in7hesky/java-selenium-allure-framework.git
```
#### 2.2 Execute run command
As soon as project is loaded, go to the root directory and perform a command:
```
mvn clean test
```
Tests will be executed in **Chrome** by default, though **Firefox** browser is also supported.  

In order to run the tests in **Firefox** provide maven with the according argument:
`-Dbrowser=firefox`.
Furthermore, you have an ability to run tests in headless mode by passing `-Dheadless=true` argument.  

For example, that's how **firefox headless** maven command should look like:
```
mvn clean test -Dbrowser=firefox -Dheadless=true
```
That will run all the tests concurrently and generate the report data. If you wish to run a particular test class you may use:
```
mvn clean test -Dtest="FilterTest"
```
Note that the name of a class is used, not the path.
## 3. Generating the report
The report data always appear after running tests. It's located in `/target/allure-results/`.
You may generate a report using:
```
allure serve target/allure-results
```
**NOTE:** If you want to change the default report data path, you can configure `allure.properties` file located in
`src/test/resources` directory.

### Extra: Jenkins integration
You may also use the `Jenkinsfile` located in the root directory to rapidly build a demo pipeline to see tests runs
and their results as Allure reports. 

Make sure you have the "Allure" Jenkins plugin installed!

Refer to https://www.jenkins.io/doc/book/pipeline/ in case you want to find out more
about `Jenkinsfile` usage.


