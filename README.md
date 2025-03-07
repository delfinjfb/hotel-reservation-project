# Hotel Reservation System - Monorepo

This repository is a **Monorepo** that contains both the **Frontend** and **Backend** code for the Hotel Reservation System.

## Project Structure

```
hotel-reservation-project/
├── backend/              # Java Spring Boot API
│   ├── src/
│   ├── pom.xml
│   └── ...
│
├── frontend/             # Angular Frontend Application
│   ├── src/
│   ├── angular.json
│   ├── package.json
│   └── ...
│
├── README.md             # Project Documentation
└── ...
```

---

## Frontend (Angular)

**Path:** `frontend/`

### Tech Stack
- Angular 16+
- Tailwind CSS
- RxJS
- TypeScript

### Setup Instructions

1. **Navigate to the frontend folder:**
   ```bash
   cd frontend
   ```

2. **Install dependencies:**
   ```bash
   npm install
   ```

3. **Run the development server:**
   ```bash
   ng serve
   ```

4. **Access the app:**
   - Open your browser and go to [http://localhost:4200](http://localhost:4200)

### API Integration

The frontend communicates with the backend API hosted at:

```
https://hotel-reservation-project.onrender.com/api/rooms
```

To avoid CORS issues during development, use the provided proxy configuration.

**Proxy Setup:**
1. Create a `proxy.conf.json` in the `frontend/` folder:

   ```json
   {
     "/api": {
       "target": "http://localhost:8080",
       "secure": false,
       "changeOrigin": true,
       "logLevel": "debug"
     }
   }
   ```

2. Update `package.json` scripts:

   ```json
   "start": "ng serve --proxy-config proxy.conf.json"
   ```

---

## Backend (Java Spring Boot)

**Path:** `backend/`

### Tech Stack
- Java 17+
- Spring Boot
- MySQL
- Maven

### Setup Instructions

1. **Navigate to the backend folder:**
   ```bash
   cd backend
   ```

2. **Run the Spring Boot application:**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Backend API Endpoints:**
   - `GET /api/rooms` → List available rooms
   - `GET /api/bookings` → List all bookings
   - `POST /api/bookings` → Create a booking

### CORS Configuration

Ensure CORS is configured in `CorsConfig.java`:

```java
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
```

---

## Deployment

### Frontend Deployment (Vercel)

1. Install Vercel CLI:
   ```bash
   npm install -g vercel
   ```

2. Deploy:
   ```bash
   cd frontend
   vercel
   ```

### Backend Deployment (Render)

1. Deploy the Spring Boot backend to [Render](https://render.com).
2. Ensure the database and environment variables are properly set.

---

## Git Workflow

### Branching Strategy

- **main**: Production-ready code
- **dev**: Development branch
- **feature/**: New features
- **bugfix/**: Fixes and patches
- **hotfix/**: Critical fixes for production

### Commit Message Convention

- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation update
- `style`: Code style changes
- `refactor`: Code restructuring
- `test`: Adding tests

### Example
```bash
git commit -m "feat: Add room listing UI component"
```

---

## Contact

For any inquiries or contributions, feel free to reach out:

- **Delfin**  
  📧 delfinjfb@gmail.com  


---

### License

This project is licensed under the MIT License.

---

**Happy Coding! 🚀**

