CREATE DATABASE recipedia;
USE recipedia;
CREATE TABLE Users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50)
);
CREATE TABLE Recipes (
    username VARCHAR(50),
    recipe_name VARCHAR(100) NOT NULL ,
    ingredients TEXT NOT NULL,
    preparation TEXT NOT NULL,
    comment TEXT,
    FOREIGN KEY (username) REFERENCES Users(username)
);
