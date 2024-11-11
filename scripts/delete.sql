-- Drop all data and tables
-- Disable foreign key checks temporarily
--SET session_replication_role = 'replica';

DROP TABLE IF EXISTS MedicineReaction;
DROP TABLE IF EXISTS FoodReaction;
DROP TABLE IF EXISTS HealthDocument;
DROP TABLE IF EXISTS Move_;
DROP TABLE IF EXISTS Animal;
DROP TABLE IF EXISTS Habitat;
DROP TABLE IF EXISTS Diet;
DROP TABLE IF EXISTS Foster;
DROP TABLE IF EXISTS Caretaker;
DROP TABLE IF EXISTS Veterinarian;
DROP TABLE IF EXISTS Curator;
DROP TABLE IF EXISTS Director;
DROP TABLE IF EXISTS Admin_;
DROP TABLE IF EXISTS Employee;
DROP TABLE IF EXISTS Address_;

-- Re-enable foreign key checks
--SET session_replication_role = 'origin';
