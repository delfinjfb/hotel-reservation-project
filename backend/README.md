# Hotel Reservation System - Backend

This is the backend service for the **Hotel Reservation System**, designed to
manage hotel bookings, customers, rooms, and seasonal pricing. It is built with
**Java 17**, **Spring Boot**, and **Hibernate** for ORM, using **H2** or *
*PostgreSQL** as the database.

---

## 📂 Project Structure

```
backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/hotelReservation/
│   │   │       ├── model/         # Entity classes
│   │   │       ├── repository/    # JPA repositories
│   │   │       ├── service/       # Business logic
│   │   │       └── controller/    # REST controllers
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-dev.properties
│   │       ├── application-prod.properties
│   │       └── data.sql          # Database initialization
├── Dockerfile                    # Docker configuration
├── pom.xml                       # Maven configuration
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- Java 17
- Maven 3.9+
- Docker (optional for containerized deployment)

### Running Locally

1. **Clone the repository**
    ```bash
    git clone <repository-url>
    cd backend
    ```
2. **Build the project**
    ```bash
    mvn clean package -DskipTests
    ```
3. **Run the application**
    ```bash
    mvn spring-boot:run -Dspring-boot.run.profiles=dev
    ```
4. **Access the application**
    - API runs on: `http://localhost:8080`
    - H2 Console (Dev): `http://localhost:8080/h2-console`

### Running with Docker

1. **Build the Docker image:**
    ```bash
    docker build -t hotel-reservation-backend .
    ```
2. **Run the Docker container:**
    ```bash
    docker run -p 8080:8080 hotel-reservation-backend
    ```

---

## ⚙️ Configuration

### Application Profiles

- **Development (default)**: Uses H2 in-memory database.
- **Production**: Uses PostgreSQL.

### Environment Variables

| Variable                 | Description                             | Default              |
|--------------------------|-----------------------------------------|----------------------|
| `SPRING_PROFILES_ACTIVE` | Active Spring profile (`dev` or `prod`) | `dev`                |
| `DB_URL`                 | Database URL                            | `jdbc:h2:mem:testdb` |
| `DB_USERNAME`            | Database username                       | `sa`                 |
| `DB_PASSWORD`            | Database password                       | `password`           |
| `H2_CONSOLE_ENABLED`     | Enable/Disable H2 Console               | `true` (Dev only)    |

---

## 🗃️ Database Schema

The database schema includes the following tables:

- `customers` - Stores customer information.
- `rooms` - Contains room details.
- `room_categories` - Categories for rooms.
- `bookings` - Customer booking records.
- `seasons` - Seasonal pricing adjustments.
- `services` - Additional service requests.

---

## 📬 API Endpoints

### Customers

- `GET /api/customers` - List all customers
- `POST /api/customers` - Create a new customer

### Rooms

- `GET /api/rooms` - List all rooms
- `POST /api/rooms` - Add a new room

### Bookings

- `GET /api/bookings` - View bookings
- `POST /api/bookings` - Create a booking

*(More endpoints to be added)*

---

## 🐳 Deployment on Render.com

1. **Add Environment Variables:**
    - `SPRING_PROFILES_ACTIVE=prod`
    - `DB_URL=jdbc:postgresql://<db-host>:5432/<db-name>`
    - `DB_USERNAME=<your-db-username>`
    - `DB_PASSWORD=<your-db-password>`

2. **Set the Root Directory** to `backend`.

3. **Deploy the service** and monitor logs.

---

## 🛠️ Technologies Used

- **Java 17**
- **Spring Boot 3.3.2**
- **Hibernate JPA**
- **H2 Database** (Dev)
- **PostgreSQL** (Prod)
- **Docker**

---

## 📄 License

This project is licensed under the MIT License.

---

## 👨‍💻 Author

**Delfin Fernandez**  
Senior Fullstack Developer  
Email: delfinjfb@gmail.com  
LinkedIn: [Delfin Fernandez](https://linkedin.com/in/delfinfernandez)

---

*Happy Coding!* 🎉

