# Book My Stay App

============================================================

PROJECT TITLE:
Book My Stay - Hotel Booking Management System

VERSION:
2.1

AUTHOR:
Amirtha S S

============================================================

PROJECT DESCRIPTION

The Book My Stay App is a console-based Hotel Booking
Management System developed to demonstrate the practical
application of Core Java and object-oriented programming
concepts in real-world software systems.

The system is designed incrementally through multiple
use cases. Each use case introduces a new concept that
helps developers understand how scalable software systems
are structured and implemented.

This implementation introduces the concept of domain
modeling using abstraction and inheritance. Different
room types are represented as objects while availability
is stored using simple variables.

This implementation covers Use Case 2:
Basic Room Types & Static Availability.

============================================================

USE CASE 2: BASIC ROOM TYPES & STATIC AVAILABILITY

At this stage, the application models different hotel
room types using object-oriented principles.

The program:

- Defines an abstract Room class
- Implements concrete classes for Single, Double,
  and Suite rooms
- Initializes room objects in the application
- Stores availability using simple variables
- Displays room details and availability to the console

============================================================

KEY CONCEPTS USED

- **Abstract Class** – Defines a generalized Room type
- **Inheritance** – SingleRoom, DoubleRoom, and SuiteRoom
  extend the Room class
- **Polymorphism** – Room objects are referenced using the
  Room type
- **Encapsulation** – Room attributes are protected inside
  the Room class
- **Static Availability Representation** – Availability
  stored using simple variables rather than data structures

============================================================

DATA STRUCTURE USED

- Primitive variables (int) for availability storage

============================================================

TECHNOLOGIES USED

- Java
- IntelliJ IDEA
- Command Line Interface (CLI)

============================================================

PROJECT STRUCTURE

BookMyStayApp/
|
|-- UseCase2RoomInitialization.java
|-- README.md

============================================================

▶ HOW TO COMPILE AND RUN THE PROGRAM

Step 1: Open Command Prompt or Terminal

Step 2: Navigate to the project folder

Example:
cd Desktop\BookMyStayApp

Step 3: Compile the program

javac UseCase2RoomInitialization.java

Step 4: Run the program

java UseCase2RoomInitialization

============================================================

EXPECTED OUTPUT

======================================
Book My Stay - Version 2.1
======================================

Single Room Details:
Beds: 1
Price per night: $80.0
Available: 5

Double Room Details:
Beds: 2
Price per night: $120.0
Available: 3

Suite Room Details:
Beds: 3
Price per night: $250.0
Available: 2

============================================================