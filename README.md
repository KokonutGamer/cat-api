## About this project
This is a simple API with only a few endpoints to test:
- `/cats`: returns all cats within the in-memory database
- `/cats/{id}`: replace id with the id of the cat you want; returns only that specific cat

## Getting started
- Run the project
  - `./mvnw clean spring-boot:run` on Linux/MacOS
  - `mvnw.cmd clean spring-boot:run` on Windows
- Check which port the application is running on
  - VSCode has a **PORTS** tab where you can check your running applications; check for one running java
  - Spring outputs to the terminal a log of how it initializes the project; check for a line that says *Tomcat initialized with port [number] (http)*
  - Usually this port should be **8080**
- In a browser, you can check what each endpoint returns by typing in `localhost:8080/{endpoint}`; you can also use the `curl` command with the corresponding HTTP method to connect to the endpoint
