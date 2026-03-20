Book My Stay App

============================================================

PROJECT TITLE:
Book My Stay - Hotel Booking Management System

VERSION:
4.0

AUTHOR:
Amirtha S S

============================================================

At Use Case 4, the application introduces a mechanism
to search and display available room types dynamically
based on current inventory data.

The program:

Retrieves room availability from centralized inventory

Displays only available room types

Filters rooms based on availability (> 0)

Provides dynamic search results to users

Ensures updated inventory is reflected in search results

Improves user experience by showing valid options only

============================================================

KEY CONCEPTS USED

Search Operation – Retrieves available rooms dynamically

Filtering – Displays only rooms with availability > 0

HashMap Traversal – Iterates through inventory data

Dynamic Data Handling – Reflects real-time availability

Separation of Concerns – Search logic separated from inventory

User-Centric Design – Shows only valid booking options

============================================================

DATA STRUCTURE USED

HashMap<String, Integer>

============================================================

EXPECTED OUTPUT

Available Rooms:

Single Room : 2
Double Room : 1

Suite Room is not available

============================================================

KEY BENEFITS

Displays only valid and available room options

Improves booking decision-making for users

Prevents selection of unavailable rooms

Reflects real-time inventory changes

============================================================