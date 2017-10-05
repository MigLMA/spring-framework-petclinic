01- pom.xml
 <!-- Spring SECURITY -->
 
 		<dependency>
		    <groupId>org.springframework.security</groupId>
		    <artifactId>spring-security-config</artifactId>
		    <version>${spring-security-config.version}</version>
		</dependency>
        <dependency>
	        <groupId>org.springframework.security</groupId>
	        <artifactId>spring-security-web</artifactId>
	        <version>${spring-security-web.version}</version>
    	</dependency>
        <!--  -->
        
02- model/User.java
03- model/Role.java

NOTES
@Table maps the entity with the table. If no @Table is defined, the default value is used: the class name of the entity.
@Id declares the identifier property of the entity.
@ManyToMany defines a many-to-many relationship between 2 entities. @JoinColumn indicates the entity is the owner of the relationship: the corresponding table has a column with a foreign key to the referenced table. mappedBy indicates the entity is the inverse of the relationship.

04- repository/UserRepository.java
04b-JdbcUserRepository.java + JpaUserRepository.java + SpringDataUserRepository.java

05- repository/RoleRepository.java
05b- Impl repositories: JdbcRoleRepository.java + JpaRoleRepository.java + SpringDataRoleRepository.java


06- service/UserDetailsServiceImpl.java

07- service/SecurityService.java 
07b- service/SecurityServiceImpl.java

08- service/UserService.java 
08b- service/UserServiceImpl.java

09- web/UserController.java

10- application.properties + validation.properties

11- config/WebSecurityConfig.java >>> configure method with all endpoints that should be authorized.

12- config/RootApplicationContextConfig > Import WebSecurityConfig.java 

13- welcome.jsp
14- resources/css/* + resources/js/*
15- messages.properties + messages_en.properties + messages_de.properties
16- login.jsp

17- DB: create Users, Roles, UserRoles
17b- populate Users, Roles, UserRoles. > use https://bcrypt-generator.com/ for passwords.




