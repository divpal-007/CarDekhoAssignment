# Spring Boot × React Starter

A minimal, production-ready full-stack starter project.

## Stack

| Layer     | Technology                     |
|-----------|-------------------------------|
| Backend   | Spring Boot 3.2, Java 17       |
| Web       | Spring MVC (REST)              |
| Database  | H2 (in-memory) / JPA + Hibernate |
| Frontend  | React 18, Vite, React Router   |
| HTTP      | Axios (with interceptors)      |
| Styling   | CSS Modules                    |

---

## Docker (Recommended)

Spin up the entire stack with a single command:

```bash
docker compose up --build
```

| URL | Service |
|-----|---------|
| http://localhost | React frontend (served by Nginx) |
| http://localhost/api/health | API via Nginx reverse proxy |
| http://localhost:8080/api/health | API direct (backend port also exposed) |
| http://localhost:8080/h2-console | H2 database console |

Stop everything:

```bash
docker compose down
```

Rebuild after code changes:

```bash
docker compose up --build
```

---

## Local Development (without Docker)

### 1. Backend

```bash
cd backend
mvn spring-boot:run
```

The API will be available at **http://localhost:8080**.

### 2. Frontend

```bash
cd frontend
npm install
npm run dev
```

The UI will be available at **http://localhost:5173**.

---

## API Endpoints

| Method | Endpoint       | Description          |
|--------|---------------|----------------------|
| GET    | /api/health   | Health check         |
| GET    | /api/hello    | Greeting (optional `?name=`) |
| POST   | /api/echo     | Echo request body    |

---

## Useful URLs

- **Frontend Dev Server** — http://localhost:5173
- **Spring Boot API** — http://localhost:8080/api
- **H2 Console** — http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:starterdb`
  - Username: `sa` | Password: *(empty)*

---

## Project Structure

```
spring-react-starter/
├── backend/
│   ├── pom.xml
│   └── src/main/java/com/starter/app/
│       ├── AppApplication.java
│       ├── controller/
│       │   ├── HelloController.java
│       │   └── GlobalExceptionHandler.java
│       ├── model/
│       │   └── ApiResponse.java
│       └── service/           ← Add your services here
└── frontend/
    ├── vite.config.js         ← API proxy configured
    └── src/
        ├── api/client.js      ← Axios instance
        ├── components/        ← Reusable UI
        └── pages/             ← Route-level components
```

---

## Production Notes

- Swap H2 for **PostgreSQL or MySQL** in `application.properties`
- Set `CORS` origins in `HelloController` to your actual domain
- Run `npm run build` and serve `dist/` via Spring Boot's static resources or a CDN
- Add Spring Security for authentication
