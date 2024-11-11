CREATE TABLE Address_ (
    id_add SERIAL PRIMARY KEY,
    street VARCHAR(50),
    city VARCHAR(50),
    region VARCHAR(50),
    postal VARCHAR(10),
    country VARCHAR(25)
);

CREATE TABLE Employee (
    id_emp SERIAL PRIMARY KEY,
    firstName VARCHAR(50),
    surname VARCHAR(50),
    degBefore VARCHAR(50),
    degAfter VARCHAR(50),
    dateOfBirth DATE,
    email VARCHAR(100) UNIQUE,
    phoneNum VARCHAR(15)[],
    salary INT[],
    address_id INT REFERENCES Address_(id_add),
    user_id VARCHAR(50),
    encryptedPasswd VARCHAR(72),
    contractBegin DATE,
    contractEnd DATE
);

CREATE TABLE Admin_ (
    employee_id INT PRIMARY KEY REFERENCES Employee(id_emp)
);

CREATE TABLE Director (
    employee_id INT PRIMARY KEY REFERENCES Employee(id_emp)
);

CREATE TABLE Curator (
    employee_id INT PRIMARY KEY REFERENCES Employee(id_emp),
    pavilion VARCHAR(50),
    education VARCHAR(50)
);

CREATE TABLE Veterinarian (
    employee_id INT PRIMARY KEY REFERENCES Employee(id_emp),
    licenseBegin DATE,
    licenseEnd DATE,
    education VARCHAR(50)
);

CREATE TABLE Caretaker (
    employee_id INT PRIMARY KEY REFERENCES Employee(id_emp),
    pavilion VARCHAR(50),
    education VARCHAR(50)
);

CREATE TABLE Foster (
    id_foster SERIAL PRIMARY KEY,
    firstName VARCHAR(50),
    surname VARCHAR(50),
    degBefore VARCHAR(50),
    degAfter VARCHAR(50),
    dateOfBirth DATE,
    email VARCHAR(100) UNIQUE,
    phoneNum VARCHAR(15)[],
    address_id INT REFERENCES Address_(id_add),
    animals JSONB
);

CREATE TABLE Diet (
    id_diet SERIAL PRIMARY KEY,
    feedType VARCHAR(25),
    foodAmount INT,
    foodItem VARCHAR(50),
    schedule JSONB
);

CREATE TABLE Habitat (
    id_habitat SERIAL PRIMARY KEY,
    pavilion VARCHAR(10),
    sizeX INT,
    sizeY INT,
    environmentType VARCHAR(100)
);

CREATE TABLE Animal (
    id_animal SERIAL PRIMARY KEY,
    pavilion VARCHAR(50),
    name_ VARCHAR(50),
    dateOfBirth DATE,
    sex BOOLEAN,
    parentOne INT REFERENCES Animal(id_animal),
    parentTwo INT REFERENCES Animal(id_animal),
    domain_ VARCHAR(100),
    phylum VARCHAR(100),
    kingdom VARCHAR(100),
    order_ VARCHAR(100),
    suborder VARCHAR(100),
    family_ VARCHAR(100),
    genus VARCHAR(100),
    species VARCHAR(100),
    diet_id INT REFERENCES Diet(id_diet),
    habitat_id INT REFERENCES Habitat(id_habitat)
);

CREATE TABLE Move_ (
    id_move SERIAL PRIMARY KEY,
    animal_id INT REFERENCES Animal(id_animal),
    move_data JSONB
);

CREATE TABLE HealthDocument (
    id_health_doc SERIAL PRIMARY KEY,
    diagnosis VARCHAR(100),
    description_ VARCHAR(255),
    medicine VARCHAR(255),
    animal_id INT REFERENCES Animal(id_animal)
);

CREATE TABLE MedicineReaction (
    id_med_reac SERIAL PRIMARY KEY,
    medName VARCHAR(100),
    medAmount INT,
    dateOfMed DATE,
    dateOfReaction DATE,
    medicine_reaction_data JSONB,
    health_doc_id INT REFERENCES HealthDocument(id_health_doc)
);

CREATE TABLE FoodReaction (
    id_food_reac SERIAL PRIMARY KEY,
    feedType VARCHAR(25),
    foodItem VARCHAR(50),
    feedAmount INT,
    dateOfFeed DATE,
    dateOfReaction DATE,
    food_ReactionData JSONB,
    health_doc_id INT REFERENCES HealthDocument(id_health_doc)
);
