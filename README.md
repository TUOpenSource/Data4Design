# Data4Design
Human-Centered Hardware Design website


Data 4 Design is a web application meant to aggregate and organize different data sets specific to geographical regions. These data sets are geographically based databases (such as population, climate, utility usage, etc.) provided by open source third parties. The data is to be organized by geographical region and displayed to a web user upon query for a specific region.

Data 4 Design is intended to assist designers and makers of physical hardware that is centered on improving the lives of those in need -- hence the name Human Centered Hardware Design. The data that the application centralizes may be of use to NGOs, university groups, and individual designers seeking to build things for humanitarian purposes. In future phases, the website may incorporate more localized and crowdsourced data 

The source code in this repository permits the user to establish their own stand-along copy of the Data 4 Design web application. It has been built using Spring Boot.

### Quick Start
To begin, simply clone the repository.

``` git clone  https://github.com/TUOpenSource/Data4Design.git```

The service is locally hosted with Apache Tomcat, so ensure Tomcat is downloaded, but do not run the service. This is handled automatically when the application builds. 

Next, make sure Maven is downloaded (Java 1.8.XX is required), navigate to the "webapp" directory (should contain the "pom.xml" file) and then run this command:
``` mvn spring-boot:run ```

The application will build, automatically initiates Tomcat, and begin serving. 
```Navigate to http://localhost:8080```