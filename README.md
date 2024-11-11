# ZOO IS project

### Start or stop containers
``docker-compose up -d`` <br>
``docker-compose down``

### Testing database connection only
``mvn exec:java -Dexec.mainClass="BE.DatabaseConnection"``

### Running the app
``mvn clean install`` when updating package etc. <br>
``mvn clean javafx:run`` or  ``mvn javafx:run``

#### Adding a style sheet (if desired)
``scene.getStylesheets().add(getClass().getResource("/lab/application.css").toExternalForm());``

Notes for myself:
Set up firewall before composing, start services (Docker)