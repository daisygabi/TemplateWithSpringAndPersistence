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
  - For more information on how to create more development environments in the project checkout this post: https://dev.to/gabriela/spring-boot-rest-api-and-flyway-migrations-a3a
5. Try running the unit tests and the integration tests that already exist. They should pass, by the way :)

Flyway is already configured and your first table will be created on running the application. The script is in resources/db.migration/V1__InitDatabase.sql
After successfully running the application, an entry will be added in the table "flyway_schema_history".
For much more details about Flyway please check their docs: https://flywaydb.org/

When you want to add more endpoints you need to allow them in the WebSecurityConfiguration class specifically or else you will get a HttpsStatus 404 back on trying to reach them.

All the names and credentials from above <b>should be renamed and made unique for your project</b>.

This project can be used only for ethical projects.
Copyright @ Gabriela Radu 2020. MIT Licenced.
