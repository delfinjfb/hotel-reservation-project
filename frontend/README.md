# Hotel Reservation Frontend

![Angular](https://img.shields.io/badge/Angular-v16-red?logo=angular)
![TypeScript](https://img.shields.io/badge/TypeScript-v4-blue?logo=typescript)
![TailwindCSS](https://img.shields.io/badge/TailwindCSS-v3-blue?logo=tailwindcss)

## 📖 Project Overview

This is the **Frontend** of the Hotel Reservation Project built with **Angular 16**, **TypeScript**, and **Tailwind CSS**. It connects to a Spring Boot REST API to handle hotel room listings, bookings, and service requests.

Live Demo: in hold 

Backend Repo: [Hotel Reservation Backend](https://github.com/delfinjfb/hotel-reservation-project/tree/main/backend)

---

## 🚀 Features

- 🏨 **Room Listing:** Displays available rooms fetched from the backend API.
- 📅 **Booking System:** Allows users to book hotel rooms.
- 🛎️ **Service Requests:** Submit service requests for hotel amenities.
- 🔒 **Admin Login:** Secure admin login for managing bookings and services.
- 🎨 **Responsive UI:** Fully responsive design using Tailwind CSS.

---

## 🛠️ Tech Stack

- **Framework:** Angular 16
- **Language:** TypeScript
- **Styling:** Tailwind CSS
- **API Integration:** REST API (Spring Boot Backend)

---

## 📂 Project Structure

```
frontend/
├── src/
│   ├── app/
│   │   ├── client/
│   │   │   ├── components/
│   │   │   │   ├── header/
│   │   │   │   ├── room-list/
│   │   │   │   ├── booking/
│   │   │   │   └── service-request/
│   │   ├── admin/
│   │   ├── auth/
│   │   ├── core/
│   │   │   └── services/
│   │   │       └── room.service.ts
│   │   └── models/
│   ├── assets/
│   └── environments/
├── angular.json
├── package.json
├── tailwind.config.js
└── README.md
```

---

## 🔧 Installation & Setup

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/delfinjfb/hotel-reservation-project.git
   
   cd hotel-reservation-frontend
   ```

2. **Install Dependencies:**
   ```bash
   npm install
   ```

3. **Run the Development Server:**
   ```bash
   ng serve
   ```
   > Open `http://localhost:4200` in your browser.

4. **Backend Setup:**
   - Ensure the backend API is running at `http://localhost:8080` or update the URL in `environment.ts`.

---

## 🌐 API Endpoint

The frontend fetches room data from the Spring Boot backend:

```bash
GET https://hotel-reservation-project.onrender.com/api/rooms
```

---

## 🏗️ Build for Production

```bash
ng build --configuration production
```

---

## ⚙️ Proxy Configuration (for local development)

To resolve CORS issues during development, create a `proxy.conf.json`:

```json
{
  "/api": {
    "target": "http://localhost:8080",
    "secure": false,
    "changeOrigin": true
  }
}
```

Add this to `angular.json`:

```json
"serve": {
  "options": {
    "proxyConfig": "src/proxy.conf.json"
  }
}
```

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

## 🤝 Contributing

1. Fork the repository.
2. Create a feature branch: `git checkout -b feature-name`
3. Commit your changes: `git commit -m "Add feature X"`
4. Push to the branch: `git push origin feature-name`
5. Open a pull request.

---

## 📞 Contact

**Delfin**  
📧 [delfinjfb@gmail.com](mailto:delfinjfb@gmail.com)  

---

Thank you for checking out this project! ⭐ If you like it, give it a star!

