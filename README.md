# MyTemplateWithSpringAndPersistence
Template project with SpringBoot, Flyway, Postgreqsql

This projects' soul purpose is to have a base to create a SpringBoot, Flyway project in a couple of minutes.
Requirements:
- Java installed. I used Java 11
- Postgresql driver installed
- A terminal (GitBash etc)
- An editor (IntelliJ etc)
- A data scheme already created with name: postgres

Steps for getting started with it in Windows:
1. git clone https://github.com/gabrielaradu/MyTemplateWithSpringAndPersistence.git
2. Add env variables for:
  REMOTEDEV_M_DB_SERVER: localhost
  REMOTEDEV_M_DB_USER: postgres
  REMOTEDEV_M_DB_PASS: admin
  REMOTEDEV_M_DB_PORT: 5433
3. Import/Open your project in your editor
4. Create SpringBoot application config with below details if you want to run the project from outside of a command line
  - Main Class: com.remote.developers.TemplateProjectApplication
  - JRE: 11 (at least)

Flyway is already configured and your first table will be created on running the application. The script is in resources/db.migration/V1__InitDatabase.sql
After successfully running the application, an entry will be added in the table "flyway_schema_history".

For more information on how to create more development environments in the project checkout this post: https://dev.to/gabriela/spring-boot-rest-api-and-flyway-migrations-a3a
For Flyway documentation: https://flywaydb.org/

All the names, credentials from above can and ~is recommended~ that you edit to make them unique to your project.
