# net_sql

## Used
- `java.net.InetAddress`, to get IP address from some URL;
- `java.sql`, to store the results of requests in `requests.db` database;
- Also `javax.swing`, for the GUI.

## Dependencies
- JDK 16+;
- Maven 3+;
- SQLite3 (in `pom.xml`).

## How to use
- In the project root directory run: `mvn clean install`;
- Will generate `target/`;
- And then run: `java -jar target/extra-1.0-SNAPSHOT.jar`;
