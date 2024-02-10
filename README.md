# SpringBoot To Do List app

- SpringBoot todo list to showing CRUD operations on MySQL Database.
- Stores todo list in MySQL database.

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Apache Maven 3.9.6](https://maven.apache.org/)

## Running the application locally


- Use IDE like intellij and modify the run configuration to add following environment variables
- In my local machine I have local installation of mysql server 8 and created a DB named TodoDB in it.

```
DB_URL=jdbc:mysql://localhost:3306/TodoDB
DB_USERNAME=root
DB_PASSWORD=mydemopassword
```

Now in run configurations add ```mvn spring-boot:run```

### Table name should be todo as defined in Todo.java
