# Recipedia

Recipedia is a Java application with a graphical user interface (GUI) that allows users to manage their recipes. Users can log in, add, view, edit, and delete recipes, as well as search for recipes based on ingredients.

## Features

- **Login/Signup**: Users can log in with their username and password, or sign up if they're new to the platform.
- **Add Recipe**: Users can add a new recipe with details such as name, ingredients, preparation instructions, and comments.
- **View Recipe**: Users can view all the recipes stored in the database.
- **Edit Recipe**: Users can edit recipes they've added, updating details such as ingredients, preparation, and comments.
- **Delete Recipe**: Users can delete recipes they've added.
- **Search Recipe**: Users can search for recipes based on ingredients.

## Prerequisites

- Java Development Kit (JDK) installed
- MySQL or another SQL database management system installed

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/palak1012/Recipedia.git
   ```

2. Open the project in your preferred IDE (Integrated Development Environment).

3. Set up the database:
   - Create a MySQL database named `recipe_database`.
   - Create a table named `Users` with columns `username` and `password`.
   - Create a table named `Recipes` with columns `username`, `recipe_name`, `ingredients`, `preparation`, and `comment`.

4. Update the database connection settings in the code:
   - Replace `URL`, `USER`, and `PASSWORD` constants in the code with your database connection details.

## Usage

1. Run the `RecipeApp` class to launch the application.

2. On the login/signup screen, enter your username and password to log in or sign up for a new account.

3. Once logged in, you'll be directed to the homepage where you can perform various tasks such as adding, viewing, editing, deleting, and searching recipes.

4. Follow the on-screen instructions to interact with the application and manage your recipes.

## Screenshots
The Users table:

<img width="253" alt="Screenshot 2024-03-14 222726" src="https://github.com/vitts3172/Recipedia/assets/95370870/4a9a3b31-8858-43fc-8fdc-fac140d3da95">

The Recipes Table:

<img width="266" alt="Screenshot 2024-03-14 222849" src="https://github.com/vitts3172/Recipedia/assets/95370870/dcaf1234-bfbb-4912-85a7-4c184f079ee0">

The Login/Signup Page:

<img width="289" alt="Screenshot 2024-03-14 223559" src="https://github.com/vitts3172/Recipedia/assets/95370870/21adcf83-e40d-4423-a62f-539ac231c173">

The Home Page:

<img width="589" alt="Screenshot 2024-03-14 224124" src="https://github.com/vitts3172/Recipedia/assets/95370870/d4130095-3018-4b88-9839-5072d234966a">

