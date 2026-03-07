# Book My Stay App

============================================================

PROJECT TITLE:
Book My Stay - Hotel Booking Management System

VERSION:
3.1

AUTHOR:
Amirtha S S

============================================================

PROJECT DESCRIPTION

The Book My Stay App is a console-based Hotel Booking
Management System designed to demonstrate the practical
application of Core Java and fundamental data structures
in solving real-world software engineering problems.

The system is developed incrementally through multiple
use cases. Each use case introduces a concept that
addresses common challenges such as inventory consistency,
state management, and system scalability.

This implementation introduces centralized room inventory
management using a HashMap data structure, replacing
the scattered availability variables used in the
previous use case.

This implementation covers Use Case 3:
Centralized Room Inventory Management.

============================================================

USE CASE 3: CENTRALIZED ROOM INVENTORY MANAGEMENT

At this stage, the application introduces a dedicated
inventory management component responsible for storing
and managing room availability in a centralized structure.

The program:

- Initializes a RoomInventory component
- Registers room types with their availability counts
- Stores availability using a HashMap
- Provides controlled methods to retrieve and update inventory
- Displays the current inventory state to the console

============================================================

KEY CONCEPTS USED

- **HashMap** – Stores room types as keys and available room counts as values
- **O(1) Lookup** – Provides fast retrieval and updates
- **Centralized State Management** – Single source of truth for availability
- **Encapsulation** – Inventory operations handled by RoomInventory class
- **Separation of Concerns** – Room inventory managed separately from room definitions
- **Scalability** – New room types can be added without changing system logic

============================================================

DATA STRUCTURE USED

- HashMap<String, Integer>

============================================================

TECHNOLOGIES USED

- Java
- IntelliJ IDEA
- Command Line Interface (CLI)

============================================================

PROJECT STRUCTURE

BookMyStayApp/
|
|-- UseCase3InventorySetup.java
|-- RoomInventory.java
|-- README.md

============================================================

▶ HOW TO COMPILE AND RUN THE PROGRAM

Step 1: Open Command Prompt or Terminal

Step 2: Navigate to the project folder

Example:
cd Desktop\BookMyStayApp

Step 3: Compile the program

javac UseCase3InventorySetup.java

Step 4: Run the program

java UseCase3InventorySetup

============================================================

EXPECTED OUTPUT

======================================
Book My Stay - Version 3.1
======================================

Current Room Inventory:

Single Room : 5
Double Room : 3
Suite Room  : 2

============================================================