<h1 style="font-size: 27px">
  <img src="../assets/icons/ss.png" width="24" height="24">  
№6 SPRING SECURITY JDBC_QUERY MYSQL BASIС AUTHENTICATION EXAMPLE
</h1>


<h1 style="color: #d7cecc; font-size: 30px; font-family: Ebrima">
   <img src="../assets/icons/logo.png" width="23" height="23">
  Project Structure
</h1>

![Untitled Diagram(1)](https://github.com/user-attachments/assets/cebcbe96-18c7-4398-80ec-561b43e2c0a8)
<h1 style="color: #d7cecc; font-size: 30px; font-family: Ebrima">
   <img src="../assets/icons/logo.png" width="23" height="23">
  Instructions for establishing a connection between a Spring Security project and a MySQL database
</h1>

> 1. Add the following dependencies to the "pom.xml" file:

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>

<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.33</version>
</dependency>
```

> 2. Set up "application.properties" file as follows:
```
spring.datasource.url=jdbc:mysql://localhost:3306/ss
spring.datasource.username=root
spring.datasource.password=test123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.sql.init.mode=always
```
> 3. Create two tables: "users" and "authorities". And add the following data to the corresponding tables in MySQL:

```
CREATE TABLE IF NOT EXISTS `ss`.`users` (
`id` INT NOT NULL AUTO_INCREMENT,
`username` VARCHAR(45) NOT NULL,
`password` VARCHAR(45) NOT NULL,
`enabled` INT NOT NULL,
PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `ss`.`authorities` (
`id` INT NOT NULL AUTO_INCREMENT,
`username` VARCHAR(45) NOT NULL,
`authority` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`));

INSERT INTO `ss`.`authorities`
(username, authority)
VALUES
('dsd', 'write');

INSERT INTO `ss`.`users`
(username, password, enabled)
VALUES
('dsd', 'test123', '1');
```

