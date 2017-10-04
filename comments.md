01- pom.xml
 <!-- Spring SECURITY -->
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

_PEND: TODO: 05- repository/RoleRepository.java >>>

import com.hellokoding.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}

05b- Impl repositories

<<< _PEND


06- service/UserDetailsServiceImpl.java

PEND_ >>> TODO >>> 07- service/SecurityServiceImpl.java
PEND_ >>> TODO >>> ...https://hellokoding.com/registration-and-login-example-with-spring-security-spring-boot-spring-data-jpa-hsql-jsp/