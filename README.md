# Storage Management System (SMS)

A Java Swing desktop application designed to streamline physical inventory management across warehouse locations, monitor stock thresholds, enforce Role-Based Access Control (RBAC), and maintain detailed system activity logs.

This project is made for the course OOP-2's Project requirement.
---

## Executive Summary & System Architecture Overview

### 1.1 Objective & Scope
The **Storage Management System (SMS)** provides warehouse managers and operators with a centralized desktop interface to:
* Manage physical inventory across granular warehouse locations (**Aisle, Shelf, Bin**).
* Track minimum stock levels with automated low-stock warnings.
* Enforce secure **Role-Based Access Control (RBAC)** for administrative vs. operational actions.
* Log all user operations for auditability and system accountability.

### 1.2 Technology Stack Mapping
* **Language & Runtime:** Java (JDK 8+)
* **GUI Engine:** Java Swing (`JFrame`, `JDialog`, `JTabbedPane`, `JTable`, `JPopupMenu`)
* **Layout Managers:** `BorderLayout`, `FlowLayout`, `GridBagLayout`
* **Data Layer:** MySQL utilizing JDBC with `PreparedStatement` transactions
* **Quality Assurance:** JUnit for automated unit and business logic testing

---

## 2. Complete GUI Window & Screen Architecture

The application operates via a primary window shell (`JFrame`) housing a role-governed `JTabbedPane` with four core modules, an authentication dialog/window (`JFrame`), and a stock adjustment dialog (`JDialog`).

### 2.1 Screen & Window Inventory Summary

| # | Screen / Module ID | Component Type | Access Level | Primary Purpose & Responsibilities |
|---|---|---|---|---|
| **1** | **W1: Login Window** | `JFrame` | Public | Authenticates users and loads the main shell according to role (`ADMIN` vs `OPERATOR`). |
| **2** | **W2: Main Application Shell** | `JFrame` + `JTabbedPane` | Admin & Operator | Top-level window hosting the role-filtered tab container and status message area. |
| **3** | **Tab 1: Inventory & Stock Ops** | `JPanel` (Tab 1) | Admin & Operator | Core stock table, item search, category filters, and quick Check-In / Check-Out triggers. |
| **4** | **Tab 2: Barcode & Location Search** | `JPanel` (Tab 2) | Admin & Operator | Barcode scanning input, item location lookup, and shelf/bin updates. |
| **5** | **Tab 3: Structure & Thresholds** | `JPanel` (Tab 3) | Admin Only | Location (Aisle/Shelf/Bin) setup, category management, and min-stock alert values. |
| **6** | **Tab 4: Users & System Logs** | `JPanel` (Tab 4) | Admin Only | Manage local user accounts and view system action logs. |
| **7** | **D1: Quick Stock Adjustment** | `JDialog` (Modal) | Admin & Operator | Compact popup dialog to enter check-in/check-out quantities. |
| **8** | **P1: Row Context Menu** | `JPopupMenu` | Admin & Operator | Right-click action menu on `JTable` rows for quick edit or stock updates. |

---

## Getting Started

### Prerequisites
* **Java Development Kit (JDK):** Version 8 or higher
* **Database:** MySQL Server 8.0+
* **Build Tool:** Maven or Gradle (Optional)

### Database Setup
1. Create a MySQL database (e.g., `sms_db`).
2. Run the provided database schema initialization script (`schema.sql`).
3. Configure your database connection credentials inside your application config or database properties file.

---
