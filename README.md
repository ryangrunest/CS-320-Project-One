# My Java Application

This is a simple Java application that demonstrates the basic structure of a Java project using Maven.

## Project Structure

```
ContactService
├── src
│   ├── main
│   │   └── java
│   │       └── App.java        # Main application class
│   └── test
│       └── java
│           └── AppTest.java    # Unit tests for the application
├── pom.xml                     # Maven configuration file
└── README.md                   # Project documentation
```

## Getting Started

To build and run the application, follow these steps:

1. **Clone the repository**:

   ```
   git clone <repository-url>
   cd ContactService
   ```

2. **Build the project**:

   ```
   mvn clean install
   ```

3. **Run the application**:
   ```
   mvn exec:java -Dexec.mainClass="App"
   ```

## Running Tests

To run the unit tests, use the following command:

```
mvn test
```

## Dependencies

This project uses JUnit for testing. The dependencies are specified in the `pom.xml` file.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.
