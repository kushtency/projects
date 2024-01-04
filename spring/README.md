# Spring

## Why Spring ?
- The main goal of spring framework is to make J2EE application development easier.
- Components of **J2EE** are:
    - Servlet
    - JSP
    - RMI
    - EJB
    - JDBC ...
- The Drawbacks for these applications are:
    - Tight Coupling : Applications should extends Servlet, EJB to perform tasks.
    - Heavy Weight : Application startup will take more extra processing.
    - Boilerplate Code : Common code is getting repeated in multiple places todo some activity.
    - Cross Cutting Concerns : This is a fancy way of saying the features which affetcts the whole application, like security, algorithm integrations, ML model integrations. These things needed to be implemented on our own as J2EE does not support them.
- Spring framework is developed by taking the above points in consideration.
- It is developed by Rod Johnson who works at sun microsystems, and earlier was known as **interface21**

## Spring Advantages :
- Made Application development easier, it is light Weight and modular, provides seperation of concern and extensible.
- The mostly used Spring Framework modules are :
    - Spring-Core       : Base module of entire framework
    - Spring-MVC        : Used to build full stack web apps
    - Spring-Security   : Provides Security to the web apps or backend
    - Spring-Web        : Used to make SOAP and REST API's for the backend
    - Spring-Batch      : Used to make batch Application
    - Spring-data       : Tool for database CRUD operations
    - Reactive-spring   : Used to write Async Code within the Spring Framework
    - Spring-cloud      : Used to Build Cloud Web Apps

## Spring Boot :
- It is a tool used to Configure Spring Applicatoin that can have one or many modules, as the name suggest Booting up the application via Spring frameworks modules to pre configure all the modules and integrate them in the application.