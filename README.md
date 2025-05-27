# 🎓 Student Management System (Java Swing + MySQL)

A simple GUI-based Student Management System built using **Java Swing** and **MySQL**. This project demonstrates database connectivity using **JDBC** and follows the **MVC (Model-View-Controller)** pattern.

---

## 📌 Features

* Add new student records
* Display all registered students in a table
* GUI designed with Java Swing
* Responsive layout and clean UI
* JDBC-based interaction with MySQL database

---

## ✅ Rubric Mapping

| Criteria                   | Marks | Implemented                         |
| -------------------------- | ----- | ----------------------------------- |
| JDK & IDE setup            | 2     | ✅ Configured for JDK 8+             |
| Project structure defined  | 1     | ✅ MVC pattern                       |
| Database schema design     | 1     | ✅ Provided SQL script               |
| MySQL table creation       | 1     | ✅ `students` table created          |
| JDBC database connectivity | 3     | ✅ Through `DBConnection.java`       |
| Model & DAO classes        | 3     | ✅ `Student.java`, `StudentDAO.java` |
| Aesthetic UI               | 4     | ✅ Styled panels, labels, inputs     |
| Component alignment        | 2     | ✅ Proper layout with GridLayout     |
| Responsive & accessible    | 2     | ✅ Resizeable frame, clean input     |

---

## 📁 Project Structure

```
StudentManagementSystem/
│
├── db/
│   └── DBConnection.java         # Manages DB connection
│
├── model/
│   └── Student.java              # Student POJO class
│
├── dao/
│   └── StudentDAO.java           # DB operations
│
├── ui/
│   └── StudentUI.java            # Swing-based UI
│
└── Main.java                     # Entry point
```

---

## 🛠️ Requirements

* Java JDK 8 or above
* MySQL Server
* IDE like IntelliJ / Eclipse / NetBeans
* MySQL Connector/J JAR

---

## 💾 Database Setup

1. Open MySQL and run the following commands:

```sql
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(100)
);
```

2. Update the credentials in `DBConnection.java`:

```java
return DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/studentdb", 
    "root", 
    "yourpassword"
);
```

---

## 🚀 How to Run

1. Clone/download the project.
2. Open in your IDE and configure your project to include:

   * MySQL Connector/J library in classpath.
3. Build and run `Main.java`.

---

## 📸 Screenshot

> *(Optional: Add a screenshot of your UI here to make it visually appealing)*

---

## 🧑‍💻 Author

Developed for academic evaluation based on GUI and DB integration skills using Java.
