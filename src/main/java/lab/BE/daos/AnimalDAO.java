package lab.BE.daos;

import lab.BE.tables.Animal;
import lab.BE.exceptions.AnimalDataAccessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    public List<Animal> getAllAnimals() throws AnimalDataAccessException {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT id_animal, name_, species, sex FROM Animal";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_animal");
                String name = resultSet.getString("name_");
                String species = resultSet.getString("species");
                boolean sex = resultSet.getBoolean("sex");
                animals.add(new Animal(id, name, species, sex));
            }

        } catch (SQLException e) {
            // NOTE: Custom exception
            throw new AnimalDataAccessException("Failed to load animals from the database.", e);
        }

        return animals;
    }
}
