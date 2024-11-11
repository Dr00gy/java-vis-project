--NOTE: missing admin

INSERT INTO Address_ (street, city, region, postal, country)
VALUES
('123 Maple St', 'Springfield', 'Central', '12345', 'USA'),
('456 Oak St', 'Rivertown', 'East', '23456', 'USA'),
('789 Pine St', 'Laketown', 'North', '34567', 'Canada'),
('101 Elm St', 'Forestville', 'South', '45678', 'Mexico'),
('202 Birch St', 'Mountainview', 'West', '56789', 'UK');

INSERT INTO Employee (firstName, surname, degBefore, degAfter, dateOfBirth, email, phoneNum, salary, address_id, user_id, encryptedPasswd, contractBegin, contractEnd)
VALUES
('John', 'Doe', 'Dr.', 'PhD', '1980-06-15', 'jdoe@example.com', '{1234567890}', '{50000}', 1, 'user_john', 'encrypted_password_1', '2020-01-01', '2025-01-01'),
('Jane', 'Smith', 'Ms.', '', '1990-04-12', 'jsmith@example.com', '{2345678901}', '{45000}', 2, 'user_jane', 'encrypted_password_2', '2021-05-01', '2026-05-01'),
('Robert', 'Brown', '', '', '1985-11-20', 'rbrown@example.com', '{3456789012}', '{55000}', 3, 'user_robert', 'encrypted_password_3', '2019-09-15', '2024-09-15'),
('Emily', 'Johnson', 'Dr.', '', '1975-02-28', 'ejohnson@example.com', '{4567890123}', '{60000}', 4, 'user_emily', 'encrypted_password_4', '2018-03-20', '2023-03-20'),
('Michael', 'White', '', 'MSc', '1995-07-08', 'mwhite@example.com', '{5678901234}', '{52000}', 5, 'user_michael', 'encrypted_password_5', '2022-07-01', '2027-07-01');

INSERT INTO Curator (employee_id, pavilion, education)
VALUES
(1, 'Tropical Pavilion', 'Biology'),
(2, 'Desert Pavilion', 'Zoology'),
(3, 'Aquatic Pavilion', 'Marine Biology'),
(4, 'Savannah Pavilion', 'Ecology'),
(5, 'Forest Pavilion', 'Wildlife Management');

INSERT INTO Veterinarian (employee_id, licenseBegin, licenseEnd, education)
VALUES
(1, '2018-01-01', '2028-01-01', 'Veterinary Medicine'),
(2, '2017-06-01', '2027-06-01', 'Animal Health'),
(3, '2019-05-01', '2029-05-01', 'Animal Science'),
(4, '2020-09-15', '2030-09-15', 'Veterinary Science'),
(5, '2021-11-20', '2031-11-20', 'Wildlife Veterinary');

INSERT INTO Caretaker (employee_id, pavilion, education)
VALUES
(1, 'Tropical Pavilion', 'Animal Care'),
(2, 'Desert Pavilion', 'Zoology'),
(3, 'Aquatic Pavilion', 'Aquaculture'),
(4, 'Savannah Pavilion', 'Conservation Biology'),
(5, 'Forest Pavilion', 'Forestry');

--NOTE: NULL values = json values
INSERT INTO Foster (firstName, surname, degBefore, degAfter, dateOfBirth, email, phoneNum, address_id, animals)
VALUES
('Liam', 'Jones', '', 'MSc', '1988-09-12', 'ljones@example.com', '{6789012345}', 1, NULL),
('Sophia', 'Williams', 'Dr.', '', '1992-02-14', 'swilliams@example.com', '{7890123456}', 2, NULL),
('Oliver', 'Taylor', '', '', '1986-07-23', 'otaylor@example.com', '{8901234567}', 3, NULL),
('Amelia', 'Davis', '', 'PhD', '1991-11-01', 'adavis@example.com', '{9012345678}', 4, NULL),
('Noah', 'Wilson', 'Mr.', '', '1993-06-18', 'nwilson@example.com', '{0123456789}', 5, NULL);

--NOTE: NULL values = json values
INSERT INTO Diet (feedType, foodAmount, foodItem, schedule)
VALUES
('Herbivore', 200, 'Lettuce', NULL),
('Carnivore', 500, 'Chicken', NULL),
('Omnivore', 300, 'Mixed Veggies', NULL),
('Herbivore', 250, 'Carrots', NULL),
('Carnivore', 400, 'Beef', NULL);

INSERT INTO Habitat (pavilion, sizeX, sizeY, environmentType)
VALUES
('Trop', 100, 200, 'Tropical Rainforest'),
('Des', 150, 250, 'Desert'),
('Aqua', 200, 300, 'Marine'),
('Sav', 120, 180, 'Savannah'),
('For', 160, 220, 'Temperate Forest');

INSERT INTO Animal (pavilion, name_, dateOfBirth, sex, domain_, phylum, kingdom, order_, suborder, family_, genus, species, diet_id, habitat_id)
VALUES
('Trop', 'Leo', '2015-05-10', true, 'Eukaryota', 'Chordata', 'Animalia', 'Carnivora', 'Fissipedia', 'Felidae', 'Panthera', 'Panthera leo', 2, 1),
('Des', 'Ellie', '2018-03-25', false, 'Eukaryota', 'Chordata', 'Animalia', 'Proboscidea', 'Elephantiformes', 'Elephantidae', 'Loxodonta', 'Loxodonta africana', 1, 2),
('Aqua', 'Sharky', '2010-07-14', true, 'Eukaryota', 'Chordata', 'Animalia', 'Chondrichthyes', 'Selachii', 'Carcharhinidae', 'Carcharhinus', 'Carcharhinus leucas', 3, 3),
('Sav', 'Zara', '2017-08-11', false, 'Eukaryota', 'Chordata', 'Animalia', 'Perissodactyla', 'Hippomorpha', 'Equidae', 'Equus', 'Equus zebra', 1, 4),
('For', 'Bambi', '2019-09-30', true, 'Eukaryota', 'Chordata', 'Animalia', 'Artiodactyla', 'Ruminantia', 'Cervidae', 'Cervus', 'Cervus elaphus', 4, 5);

--NOTE: NULL values = json values
INSERT INTO Move_ (animal_id, move_data)
VALUES
(1, NULL),
(2, NULL),
(3, NULL),
(4, NULL),
(5, NULL);

INSERT INTO HealthDocument (diagnosis, description_, medicine, animal_id)
VALUES
('Flu', 'Mild flu symptoms', 'Antibiotics', 1),
('Fracture', 'Broken leg', 'Painkillers', 2),
('Infection', 'Skin infection', 'Antifungal cream', 3),
('Allergy', 'Seasonal allergy', 'Antihistamines', 4),
('Obesity', 'Overweight due to overfeeding', 'Dietary control', 5);

--NOTE: NULL values = json values
INSERT INTO MedicineReaction (medName, medAmount, dateOfMed, dateOfReaction, medicine_reaction_data, health_doc_id)
VALUES
('Antibiotics', 500, '2023-05-10', '2023-05-15', NULL, 1),
('Painkillers', 200, '2022-02-01', '2022-02-05', NULL, 2),
('Antifungal Cream', 100, '2021-12-10', '2021-12-15', NULL, 3),
('Antihistamines', 50, '2023-04-12', '2023-04-14', NULL, 4),
('Dietary Control', 0, '2023-08-01', '2023-08-10', NULL, 5);

--NOTE: NULL values = json values
INSERT INTO FoodReaction (feedType, foodItem, feedAmount, dateOfFeed, dateOfReaction, food_ReactionData, health_doc_id)
VALUES
('Herbivore', 'Lettuce', 200, '2022-06-01', '2022-06-02', NULL, 1),
('Carnivore', 'Chicken', 500, '2023-07-15', '2023-07-16', NULL, 2),
('Omnivore', 'Mixed Veggies', 300, '2023-01-10', '2023-01-12', NULL, 3),
('Herbivore', 'Carrots', 250, '2021-11-25', '2021-11-26', NULL, 4),
('Carnivore', 'Beef', 400, '2023-09-20', '2023-09-21', NULL, 5);
