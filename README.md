# 🌟 Event Management System

## 1. 📋 Project Overview

### 1.1 🎯 General Objectives:
This project is developed as part of the "POO Java 8 & Mini-Project" course. The main goal is to create a Java-based application that manages events and participant registrations. This project covers analysis, design, and implementation of a system that allows administrators to manage events and participants, while users can register for events.

### 1.2 📝 Problem Statement:

The system allows an organization to manage various events, such as conferences, seminars, and workshops. It includes functionalities for administrators to create, update, delete, and list events, as well as manage participant registrations. Participants can register for events and view the events they are registered for.

### 1.3 💻 Key Features:
- **Event Management:**
  - Create, update, delete, and list events.
  - Search events by title, date, location, and type.
  
- **Participant Management:**
  - Add, update, delete, and list participants.
  
- **Registration Management:**
  - Register participants for events.
  - Display events for a specific participant.
  - Cancel a registration.

## 2. 🏗️ Project Structure

```plaintext
.
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── model
│   │   │   │   ├── Event.java
│   │   │   │   ├── Participant.java
│   │   │   │   └── Registration.java
│   │   │   ├── service
│   │   │   │   ├── EventService.java
│   │   │   │   ├── ParticipantService.java
│   │   │   │   └── RegistrationService.java
│   │   │   ├── interfaces
│   │   │   │   ├── InterfaceEvent.java
│   │   │   │   ├── InterfaceParticipant.java
│   │   │   │   └── InterfaceRegistration.java
├── │   │   │   ├── Menu.java
│   │   │   └── Main.java
├── README.md
