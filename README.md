# MetaSeo Service

The **MetaSeo Service** manages SEO-related metadata for posts and pages in the QuantumGrid platform.

## Features

- Manage SEO metadata (title, description, keywords)
- Generate and manage sitemaps
- Monitor SEO performance metrics
- Integration with external SEO tools

## Technology Stack

- **Java**: Programming language
- **Spring Boot**: Microservice framework
- **PostgreSQL**: Relational database for storing SEO metadata

## Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven** for build automation
- **PostgreSQL** installed and running

### Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/bobnetnetwork/quantumgrid-metaseo-service.git
    cd quantumgrid-metaseo-service
    ```

2. Configure the database connection in `src/main/resources/application.properties`:
    ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/quantumgrid
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    ```

3. Build the application:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

### API Endpoints

- `POST /api/seo` - Add or update SEO metadata
- `GET /api/seo/{id}` - Get SEO metadata details
- `DELETE /api/seo/{id}` - Delete SEO metadata

## Contributing

Please read the [CONTRIBUTING.md](https://github.com/bobnetnetwork/quantumgrid/blob/main/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests.

## License

This project is licensed under the GPL-3.0 license - see the [LICENSE.md](https://github.com/bobnetnetwork/quantumgrid/blob/main/LICENSE.md) file for details.
