# Book My Stay App

============================================================

PROJECT TITLE:
Book My Stay - Hotel Booking Management System

VERSION:
3.1

AUTHOR:
Amirtha S S

============================================================
At this stage, the application introduces a mechanism
to store and manage confirmed bookings in a structured
and ordered manner for reporting and administrative use.

The program:

Stores each confirmed reservation in booking history

Maintains records in the order they are confirmed

Uses a List data structure to preserve chronological order

Provides read-only access to stored booking data

Generates summary reports from booking history

Ensures reporting does not modify original data

============================================================

KEY CONCEPTS USED

List (ArrayList) – Stores booking history in insertion order

Ordered Storage – Maintains chronological sequence of bookings

Operational Visibility – Enables tracking of past reservations

Historical Tracking – Creates an audit trail of bookings

Separation of Concerns – Data storage and reporting handled separately

Read-Only Data Access – Prevents modification during reporting

Reporting Readiness – Structured data enables easy report generation

============================================================

DATA STRUCTURE USED

List<Reservation>

============================================================

EXPECTED OUTPUT

Processing: Alice
Booking Confirmed for Alice

Processing: Bob
Booking Confirmed for Bob

Processing: Charlie
Booking Failed for Charlie

--- Booking History ---
RES-1 | Alice | Single
RES-2 | Bob | Double

--- Booking Summary ---
Total Bookings: 2
Total Rooms Booked: 3

============================================================

KEY BENEFITS

Maintains complete booking audit trail

Enables reporting and administrative analysis

Improves system transparency

Supports future scalability and persistence

============================================================

LIMITATION OF PREVIOUS USE CASE (UC7)

No booking history tracking

No reporting capability

No visibility into past bookings

==============================================================