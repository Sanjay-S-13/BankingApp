# 🏦 Banking System Application

This is a robust and professional console-based banking system developed in Java. The application is designed to simulate core banking functionalities for both administrators and general users. It leverages modern Java concepts and a layered architecture to ensure a clean, maintainable, and scalable codebase.

---

## 🚀 Features

### Admin Privileges
- **Customer Management:** Admins can easily add new customer accounts to the system.
- **Financial Oversight:** Admins can view any customer's account balance and transaction history to ensure financial transparency.
- **Cheque Book Administration:** Admins can manage and approve cheque book requests from users.

### User Functionality
- **Account Balance Inquiry:** Users can check their current account balance instantly.
- **Secure Fund Transfers:** Users can transfer money to other users securely.
- **Transaction History:** Users can access a detailed history of all debit and credit transactions.
- **Cheque Book Request:** Users can submit a request for a new cheque book.

---

## 🛠️ Technical Concepts

This project showcases several professional software development concepts, including:

- **Object-Oriented Programming (OOP):** The system is built around classes like `User`, `Transactions`, `UserService`, and `UserRepo`, demonstrating principles of **encapsulation**, **abstraction**, and modular design.
- **Layered Architecture:** The application is structured into distinct layers, promoting a separation of concerns:
    - **`main`:** Handles the user interface and application flow.
    - **`services`:** Contains the business logic, acting as an intermediary between the UI and the data layer.
    - **`repository`:** Manages data persistence, simulating a database using in-memory collections like `HashSet` and `HashMap`.
- **Data Structures:** The system efficiently uses standard Java collections (`Set`, `List`, `Map`) to store and manage data. A `HashSet` is used for storing users to ensure their uniqueness.
- **Java Stream API:** Modern Java Stream API is used for efficient data processing, such as filtering users and transactions, leading to more concise and readable code.
- **Robust Error Handling:** The application includes basic checks for common issues like incorrect credentials or insufficient funds, providing a smoother user experience.
- **Modularity:** The code is organized into separate packages (`main`, `services`, `repository`, `entity`), promoting a highly organized and reusable structure.

---


## 📞 Contact

For any questions or professional inquiries, please feel free to connect with me:

- **LinkedIn:** [https://www.linkedin.com/in/sanjays13-/](https://www.linkedin.com/in/sanjays13-/)
- **Email:** sanjays.workspace@gmail.com
