# Campus Recruitment System

A full-stack Campus Recruitment Platform built using Spring Boot, React, MySQL, and JWT Authentication.

This platform helps students apply for jobs, recruiters post opportunities, and admins manage the complete recruitment process.

---

#  Features

## 🔐 Authentication
- JWT-based login system
- Role-based access
- Student / Recruiter / Admin roles

---

## 👨‍🎓 Student Module
- Create student profile
- View available jobs
- Apply for jobs
- View applied jobs
- Update profile

---

## 🏢 Recruiter Module
- Recruiter registration
- Create jobs
- Update jobs
- Delete jobs
- View applications

---

## 💼 Job Module
- Create job postings
- Search jobs
- Pagination support
- View single job details
- Job type support:
  - FULL_TIME
  - INTERNSHIP
  - REMOTE

---

## 📄 Application Module
- Apply to jobs
- Track applications
- Recruiter can manage applicants

---

## 🛠️ Admin Module
- Dashboard statistics
- Manage students
- Manage recruiters
- Manage jobs
- Manage applications

---

# 🧱 Tech Stack

## Backend
- Java 21
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- MySQL
- Maven
- Lombok

---

## Frontend
- React
- Vite
- Axios
- React Router

---

# 📂 Project Structure

## Backend Structure

```text
src/main/java/com/meghana/campusrecruitment
│
├── controller
├── service
├── repository
├── entity
├── dto
├── config
├── security

## Frontend Structure

```text
src/
│
├── pages/
├── components/
├── services/
├── routes/
├── context/
├── layouts/
```

---

# ⚙️ Backend Setup

## Clone Repository

```bash
git clone https://github.com/meghana5226/campus-recruitment-system.git
```

---

## Open Backend

```bash
cd campus-recruitment-system
```

---

## Configure MySQL

Update:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/campus_recruitment_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Run Backend

```bash
./mvnw spring-boot:run
```

Backend runs on:

```text
http://localhost:8080
```

---

# ⚙️ Frontend Setup

## Open Frontend Folder

```bash
cd campus-frontend
```

---

## Install Dependencies

```bash
npm install
```

---

## Run Frontend

```bash
npm run dev
```

Frontend runs on:

```text
http://localhost:5173
```

---

# 🔑 API Endpoints

## Authentication

```text
POST /api/auth/register
POST /api/auth/login
```

---

## Jobs

```text
GET    /api/jobs
GET    /api/jobs/{id}
POST   /api/jobs
PUT    /api/jobs/{id}
DELETE /api/jobs/{id}
```

---

## Applications

```text
POST /api/applications
GET  /api/applications/student/{id}
```

---

## Admin

```text
GET /api/admin/dashboard
```

---

# 📌 Future Improvements

* Resume upload
* Email notifications
* Interview scheduling
* Swagger API docs
* Docker deployment
* Cloud deployment
* Redis caching
* Analytics dashboard

---

# 👩‍💻 Author

Developed by Meghana
