# Task Assignment Application - Admin Controller

This repository contains the source code for the Admin Controller of the Task Assignment Application. The Admin Controller manages functionalities related to consultant requests and approvals within the system.

## Endpoints for Admin Controller

### 1. Request List

- **Endpoint:** `/admin/req_list`
- **Method:** GET
- **Description:** Retrieve the list of all consultant requests.
- **Response:** 
  - 200 OK with a list of `RequestTable` objects.
  - 500 Internal Server Error with an empty list in case of an exception.

### 2. Statistics

- **Endpoint:** `/admin/total`
- **Method:** GET
- **Description:** Retrieve the total number of approved consultants.
- **Response:** 
  - 200 OK with a `Long` representing the total number.
  - 500 Internal Server Error with a null response in case of an exception.

### 3. Accepted List

- **Endpoint:** `/admin/allData`
- **Method:** GET
- **Description:** Retrieve the list of all approved consultants.
- **Response:** 
  - 200 OK with a list of `Consultant_table` objects.
  - 500 Internal Server Error with an empty list in case of an exception.

### 4. Approve Request

- **Endpoint:** `/admin/approve/{id}`
- **Method:** POST
- **Description:** Approve a consultant request by its ID.
- **Response:** 
  - 200 OK with a success message.
  - 500 Internal Server Error with an error message in case of an exception.

### 5. Reject Request

- **Endpoint:** `/admin/reject/{id}`
- **Method:** POST
- **Description:** Reject a consultant request by its ID.
- **Response:** 
  - 200 OK with a success message.
  - 500 Internal Server Error with an error message in case of an exception.

### 6. Search by Name

- **Endpoint:** `/admin/search/name/{name}`
- **Method:** GET
- **Description:** Search for an individual consultant by name.
- **Response:** 
  - 200 OK with a `Consultant_table` object.
  - 500 Internal Server Error with an error message in case of an exception.

### 7. Search by Role

- **Endpoint:** `/admin/search/role/{role}`
- **Method:** GET
- **Description:** Search for an individual consultant by role.
- **Response:** 
  - 200 OK with a `Consultant_table` object.
  - 500 Internal Server Error with an error message in case of an exception.

## Endpoint for user

### 1. Post Request

- **Endpoint:** `/request`
- **Method:** POST
- **Description:** Submit a request for a consultant.
- **Request Body:** 
  - `RequestTable` object containing information about the consultant request.
- **Response:** 
  - 200 OK with a success message if the request is processed successfully.
  - 500 Internal Server Error with an error message in case of an exception.
## Exception Handling

- All exceptions are handled, and appropriate HTTP status codes and error messages are provided in the responses.

## Notes

- This controller is part of a larger Task Assignment Application managing consultant requests and approvals.
- Make sure to configure the application properties appropriately, including the database connection settings and file storage paths.

