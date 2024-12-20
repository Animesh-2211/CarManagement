# Car Management System API

## Overview
This API allows users to perform CRUD operations for managing car details. The available endpoints include functionality to add, update, delete, and retrieve cars based on various parameters such as name, model, and year.

## API Endpoints

### 1. Add a New Car
- **Method:** POST
- **Endpoint:** `/api/cars`
- **Description:** Adds a new car to the system.
<img width="960" alt="image" src="https://github.com/user-attachments/assets/b2c08790-3d31-4584-ba55-692a39de035c" />


### 2. Get All Cars
- **Method:** GET
- **Endpoint:** `/api/cars`
- **Description:** Retrieves a list of all cars available in the system.
- <img width="960" alt="image" src="https://github.com/user-attachments/assets/db54ee5f-fc4f-4e41-986c-fc5ee18036f8" />


### 3. Get a Car by Name
- **Method:** GET
- **Endpoint:** `/api/cars/name/{name}`
- **Description:** Retrieves a specific car's details by its name.
-  <img width="960" alt="image" src="https://github.com/user-attachments/assets/045cf82e-dda3-48f2-a98a-c76d47469bf5" />

### 4. Update a Car by Name
- **Method:** PUT
- **Endpoint:** `/api/cars/name/{name}`
- **Description:** Updates the details of a car by its name.

<img width="960" alt="image" src="https://github.com/user-attachments/assets/7f492f3e-3377-4a70-abb5-2f4c27a151fe" />



### 5. Delete a Car by Name
- **Method:** DELETE
- **Endpoint:** `/api/cars/name/{name}`
- **Description:** Deletes a car from the system based on its name.
- <img width="960" alt="image" src="https://github.com/user-attachments/assets/012ccec8-cee9-4ac7-8b38-f6a13587487d" />


### 6. Search Cars by Model or Year
- **Method:** GET
- **Endpoint:** `/api/cars/search?model={model}&year={year}`
- **Description:** Searches for cars based on their model, year, or both.
- <img width="960" alt="image" src="https://github.com/user-attachments/assets/1a3c9008-f02f-4aed-8dce-d332122d57e0" />
<img width="960" alt="image" src="https://github.com/user-attachments/assets/c02cc529-07c8-4672-b20f-aa2d71a33739" />



### 7. Pagination and Sorting
- **Method:** GET
- **Endpoint:** `/api/cars?page={pageNumber}&size={pageSize}&sort={field}`
- **Description:** Retrieves a paginated and optionally sorted list of cars based on a specified field.
- <img width="960" alt="image" src="https://github.com/user-attachments/assets/79b4deb3-3389-48ef-9136-461c9861b150" />


---

## Technologies Used
- **Spring Boot** for building the REST API.

- **SQL Database** for storing car details.
<img width="960" alt="image" src="https://github.com/user-attachments/assets/2fefdf4a-11e4-4282-a0df-246c6e81e6ae" />


---


