# Tourist Record & Hotel Check-in System

Spring Boot REST API with JWT request-token validation and a tourist ID update endpoint.

## Requirements
- JDK 17 or later
- Maven 3.6+ (or import `pom.xml` into Spring Tool Suite / Eclipse / IntelliJ)

## Run
From this project folder:

```bash
mvn spring-boot:run
```

The application starts at `http://localhost:8080`.

## Step 1: Generate a valid request token

Send:

```http
POST http://localhost:8080/api/auth/token
Content-Type: application/json
```

Body:

```json
{
  "username": "admin",
  "password": "admin123"
}
```

Copy the `token` value from the response. The demo token is valid for one hour.

## Step 2: Update a tourist using ID

Send:

```http
PUT http://localhost:8080/api/tourists/1
Authorization: Bearer YOUR_TOKEN_HERE
Content-Type: application/json
```

Body:

```json
{
  "contactNumber": "9988776655",
  "email": "ravi.new@example.com",
  "visitedDestination": "Tirupati",
  "hotelName": "Hotel Grand"
}
```

Only non-null fields in the request are updated. The API saves the updated record to the H2 database and returns it.

## Verify the update

```http
GET http://localhost:8080/api/tourists/1
Authorization: Bearer YOUR_TOKEN_HERE
```

## Expected results
- Valid token + existing ID: `200 OK`, updated tourist JSON.
- Missing, invalid, or expired token: `401 Unauthorized`.
- Valid token + unknown ID: `404 Not Found`.
- Invalid login credentials: `401 Unauthorized`.

## Sample records
The application inserts two sample tourists when the database is empty:
- ID 1: Ravi Kumar
- ID 2: Sita Devi

## H2 database console
Open `http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:mem:touristdb`
- User Name: `sa`
- Password: leave blank

This is a lab/demo project. The username and password are hard-coded for demonstration; use a proper user store and secret management in a real application.
