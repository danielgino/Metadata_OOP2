#  Metadata Modeling System – Assignment 3, Question 1  
## Object-Oriented Programming 2  

---

## Overview

This project implements a **general metadata definition mechanism**, using core object-oriented programming principles in Java.  
It models **components**, **attributes**, and **relations** to represent metadata entities and processes in a structured way.

The solution answers **Question 1** from Assignment 3 and is designed to be **extensible**, **modular**, and **file-driven**.

---

##  Problem Description 

We were required to implement:
- A **Component** class representing any metadata entity (e.g., Business Process, Activity, Microservice, Customer).
- An **Attribute** class representing name-value pairs associated with Components and Relations.
- A **Relation** class connecting two components with a type (`CONNECTS`, `GROUPING`, etc.).
- A **MetadataModel** to store and manage all components and their relations.
- A loader that can **read components and relations from CSV files**.
- A simple CLI `Main` class to load and print the metadata model.

---

##  Project Structure

```
│
├── Attribute.java # Represents metadata attribute (key-value)
├── Component.java # Represents a metadata component
├── Relation.java # Represents connection between two components
├── MetadataModel.java # Central model holding all components and relations
├── DataLoader.java # Loads metadata from CSV files
└── Main.java # Entry point, loads and prints the model
```


Component
Represents a metadata entity like a process or customer:
```
new Component("Create Customer", "Business Process");
```

Relation
Represents a directed connection between two components:
```
new Relation("flows to", comp1, comp2, List.of(new Attribute("type", "CONNECTS")));
```

MetadataModel
Holds all loaded components and relations, allows:

Adding new elements
Searching components by name
Printing the entire model
### Input File Formats

components.csv
name,type,id,createdBy
Create Customer,Business Process,C001,Admin
Store Customer,Activity,C002,Admin

relations.csv
from,name,to,type
Create Customer,flows to,Store Customer,CONNECTS

# Run Example + Output
```
=== Components ===
Activity: Get Customer Information [Description=Receive customer input]
Activity: Validate Customer Information [Description=Check validity of data]
Activity: Store Customer [Description=Save the customer to database]
Business Process: Create New Customer [Description=Start the process]
Interface: Interface 1 [Description=Used in step 1]
Interface: Interface 2 [Description=Used in step 2]
Interface: Interface 3 [Description=Used in step 3]
Customer: Customer 1 [Description=First customer created]
Customer: Customer 2 [Description=Second customer created]

=== Relations ===
Create New Customer --flows to--> Get Customer Information
Get Customer Information --flows to--> Validate Customer Information
Validate Customer Information --flows to--> Store Customer
Get Customer Information --uses--> Interface 1
Validate Customer Information --uses--> Interface 2
Store Customer --uses--> Interface 3
Interface 1 --connects to--> Customer 1
Interface 2 --connects to--> Customer 2
Interface 3 --connects to--> Customer 1

```

