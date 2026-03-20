============================================================

PROJECT TITLE:
Book My Stay - Hotel Booking Management System

VERSION:
9.0

AUTHOR:
Amirtha S S

============================================================

At this stage, the application introduces structured
validation and error handling to ensure that invalid
inputs and inconsistent system states are detected
and handled early.

The program:

Validates booking input before processing

Checks if the room type exists in inventory

Prevents invalid or negative room allocation

Uses custom exceptions for invalid booking scenarios

Displays meaningful error messages on failure

Ensures system continues running safely after errors

============================================================

KEY CONCEPTS USED

Input Validation – Ensures data correctness before processing

Custom Exceptions – Represents domain-specific errors clearly

Fail-Fast Design – Detects errors early and stops invalid operations

State Protection – Prevents invalid inventory updates

Graceful Failure Handling – Avoids system crashes with proper messages

Defensive Programming – Handles incorrect inputs, not just ideal cases

============================================================

DATA STRUCTURE USED

HashMap<String, Integer>

List<Reservation>

============================================================

EXPECTED OUTPUT

Processing: Alice
Booking Confirmed for Alice

Processing: Bob
Error: Invalid room type

Processing: Charlie
Error: Not enough rooms available

Processing: David
Error: Invalid room count

System continues running safely...

============================================================

KEY BENEFITS

Early detection of invalid inputs

Prevents system crashes and data corruption

Improves reliability and stability

Enhances debugging and maintainability

============================================================

LIMITATION OF PREVIOUS USE CASE (UC8)

Assumed all inputs were valid

No validation for incorrect data

Risk of invalid system states and incorrect reports

============================================================