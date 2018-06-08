# spring-boot-Contact
A Simple Contact management Application implemented using Spring Boot &amp; Spring Data JPA 

This Appication is built for learning Spring boot , Hibernate with Spring Data JPA , Hibernate Validator.

It uses only three tables 

User          - to manage login 
Contact       - to Store User's contact information like name , Email id (Like Contacts in Phone) 
              and it has unidirectional many to one mapping with User .
ContactPhone  - to Store Phone numbers(yes! can store more phone number for each contcat) information for 
               each contact and it has unidirectional many to one mapping with Contact
               
As part of Spring MVC , this application implements
    - Request Mapping using annotations and usage of Controller,Repository annotations
    - Front End Forms to Back End DataBinding
    - Autowiring of required objects
    - Redirection from one controller to another using flashattributes
As part of Hibernate Validator, this application implements
    - Null check , length check using annotations
    - Cross field verification using class level user defined annotations
    - Usage Valid and bindingresult annotation in controller classes
As part of Spring Data JPA 
    - Usage of CRUD repository 
    - Usage of findBy and delet methods using different name patterns
As part of Hibernate ORM
    - Usage of Entity , ID annotations
    - Usage of Mapping annotations
    - used only unidirectional Many to One mapping
    -Usage of Query and Param annotations while using JPQL 
    -Usage of Transactional annotations while deleteby pattern methods 
 
 
 
 What features can be implemented further ?
 
 - AOP for logging and security session check before accessing crtical controller methods
 - Hibernate - Fetch Type 
 - Spring Session using Redis Db for clustered session management
 
 References:
 
 https://stackoverflow.com/questions/44170533/spring-data-jpa-how-to-enable-cascading-delete-without-a-reference-to-the-child
 https://stackoverflow.com/questions/48610226/how-to-construct-spring-jpa-jpql-query-in-jparepository
 https://stackoverflow.com/questions/32741333/session-management-in-microservices
 https://stackoverflow.com/questions/32269192/spring-no-entitymanager-with-actual-transaction-available-for-current-thread
 https://stackoverflow.com/questions/23862994/what-is-the-difference-between-hibernate-and-spring-data-jpa
 https://stackoverflow.com/questions/23700540/cross-cutting-concern-example
 
