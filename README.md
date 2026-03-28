# ⚽ Premier League Management API
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)
![Python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)

A simple and efficient REST API for managing Premier League football player statistics. 
The data is automatically collected from the web using a Python script and saved to a database. The Java (Spring Boot) backend then allows users to view, add, or delete players securely.

## ✨ What it does
* **Python Web Scraping:** A custom script extracts real player stats from the internet and populates the database automatically.
* **Database Management:** Uses PostgreSQL to safely store players and run custom queries to sort or filter them.
* **JWT Security:** Features a login system with User and Admin roles. You need a valid JSON Web Token (JWT) to access protected information.
* **Clean Error Handling:** Instead of crashing or showing ugly server errors, the API catches mistakes and returns friendly, easy-to-read JSON error messages.

## 🛠️ Tech Stack
* **Backend:** Java 21, Spring Boot
* **Database:** PostgreSQL
* **Security:** Spring Security, JWT (JSON Web Tokens)
* **Data Gathering:** Python
* **Tools:** Maven, Postman, Git

## 📍 API Endpoints
| Method | Endpoint | What it does | Access Level |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/auth/register` | Creates a new user account | Public |
| `POST` | `/api/auth/login` | Logs in and gives you a Token | Public |
| `GET` | `/api/players` | Gets the list of players | Needs Token |
| `GET` | `/api/players/team/{teamName}` | Gets players by team | Needs Token |
| `GET` | `/api/players/top-scorers` | Gets top 10 scorers | Needs Token |
| `GET` | `/api/players/search?name={name}` | Search player by name | Needs Token |
| `POST` | `/api/players` | Adds a new player | Admin Only |
| `DELETE` | `/api/players/{id}` | Deletes a player | Admin Only |

## 💻 Local Setup
Want to run this project on your own machine? Follow these steps:

### 1. Prerequisites
Make sure you have the following installed on your computer:
* Java 21 or higher
* PostgreSQL
* Maven

### 2. Installation & Configuration

**Clone the repository:**
```bash
git clone https://github.com/badiu-damian/premier-league-api.git
cd premier-league-api
```

**Set environment variables:**
```
DB_URL=jdbc:postgresql://localhost:5432/prem_stats
DB_USERNAME=your_username
DB_PASSWORD=your_password
```

**Run the application:**
```bash
./mvnw spring-boot:run
```

The API will start on **http://localhost:8080**

## 🚀 Project Status
**[IN PROGRESS]** - Currently finishing the Login/Register system.
Next step: building a React frontend so users can see the data in a browser.
