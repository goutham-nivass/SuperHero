# Superhero Explorer 🦸‍♂️

A Java-based web application that fetches and displays superhero data from the SuperHero API. This application provides an interactive interface to explore your favorite superheroes with advanced filtering capabilities.

## Features ✨

- Fetch superhero data from SuperHero API
- Advanced filtering options:
  - Filter by name
  - Filter by publisher (DC, Marvel, etc.)
  - Filter by powers
  - Filter by alignment (good/bad)
- Responsive and modern UI design
- Detailed superhero information display
- Pagination support
- Caching mechanism for better performance

## Technologies Used 🛠️

- Java 17
- Spring Boot
- Spring WebFlux (for reactive programming)
- Thymeleaf (templating engine)
- Bootstrap 5 (UI framework)
- Maven (dependency management)
- H2 Database (for caching)
- JUnit 5 & Mockito (testing)

## Prerequisites 📋

- JDK 17 or higher
- Maven 3.6 or higher
- SuperHero API access token ([Get it here](https://superheroapi.com/))

## Installation & Setup 🚀

1. Clone the repository
```bash
git clone https://github.com/yourusername/superhero-explorer.git
cd superhero-explorer
```

2. Configure API Key
   - Create `application.properties` file in `src/main/resources`
   - Add your SuperHero API key:
```properties
superhero.api.key=YOUR_API_KEY_HERE
```

3. Build the project
```bash
mvn clean install
```

4. Run the application
```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

## Project Structure 📁

```
superhero-explorer/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/superhero/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       └── config/
│   │   └── resources/
│   │       ├── templates/
│   │       └── static/
│   └── test/
├── pom.xml
└── README.md
```

## API Integration 🔌

The application integrates with the following SuperHero API endpoints:

- `/api/search/{name}` - Search heroes by name
- `/api/{id}` - Get detailed hero information
- `/api/powerstats/{id}` - Get hero power statistics
- `/api/biography/{id}` - Get hero biography

## Contributing 🤝

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Testing 🧪

Run the test suite using:
```bash
mvn test
```

## Error Handling 🚨

The application implements comprehensive error handling:
- API rate limit management
- Network error handling
- Invalid data validation
- User-friendly error messages

## Caching Strategy 📦

- Implements in-memory caching for frequently accessed heroes
- Cache invalidation after 24 hours
- Configurable cache size and timeout

## Performance Optimization 🚀

- Reactive programming with WebFlux
- Pagination for large result sets
- Image optimization
- Minified CSS/JS resources

## License 📄

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
