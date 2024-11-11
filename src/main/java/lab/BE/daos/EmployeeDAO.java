package lab.BE.daos;

import lab.BE.tables.employees.*;
import lab.BE.exceptions.UserDataAccessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class EmployeeDAO {

    public List<Employee> getAllEmployees() throws UserDataAccessException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT id_emp, firstName, surname, degBefore, degAfter, dateOfBirth, email, phoneNum, salary, user_id, encryptedPasswd, contractBegin, contractEnd FROM Employee";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_emp");
                String firstName = resultSet.getString("firstName");
                String surname = resultSet.getString("surname");
                String degBefore = resultSet.getString("degBefore");
                String degAfter = resultSet.getString("degAfter");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                String email = resultSet.getString("email");

                Array phoneArray = resultSet.getArray("phoneNum");
                String[] phoneNum = (phoneArray != null) ? (String[]) phoneArray.getArray() : new String[0];

                Array salaryArray = resultSet.getArray("salary");
                Integer[] salaryInteger = (salaryArray != null) ? (Integer[]) salaryArray.getArray() : new Integer[0];
                int[] salary = Arrays.stream(salaryInteger).mapToInt(Integer::intValue).toArray();

                String userId = resultSet.getString("user_id");
                String encryptedPasswd = resultSet.getString("encryptedPasswd");
                Date contractBegin = resultSet.getDate("contractBegin");
                Date contractEnd = resultSet.getDate("contractEnd");

                Employee employee = loadEmployeeSubclass(id, firstName, surname, degBefore, degAfter, email, phoneNum, salary, userId, encryptedPasswd);
                if (employee != null) {
                    employees.add(employee);
                }
            }
        } catch (SQLException e) {
            throw new UserDataAccessException("Failed to load employees from the database.", e);
        }
        return employees;
    }

    private Employee loadEmployeeSubclass(int id, String firstName, String surname, String degBefore, String degAfter, String email, String[] phoneNum, int[] salary, String userId, String encryptedPasswd) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (isSubclassRecordPresent(connection, "Admin_", id)) {
                return new Admin(id, firstName, surname, degBefore, degAfter, null, email, phoneNum, salary, null, userId, encryptedPasswd, null, null);
            }

            if (isSubclassRecordPresent(connection, "Director", id)) {
                return new Director(id, firstName, surname, degBefore, degAfter, null, email, phoneNum, salary, null, userId, encryptedPasswd, null, null);
            }

            if (isSubclassRecordPresent(connection, "Curator", id)) {
                String pavilion = fetchAdditionalField(connection, "Curator", "pavilion", id);
                String education = fetchAdditionalField(connection, "Curator", "education", id);
                return new Curator(id, firstName, surname, degBefore, degAfter, null, email, phoneNum, salary, null, userId, encryptedPasswd, null, null, pavilion, education);
            }

            if (isSubclassRecordPresent(connection, "Veterinarian", id)) {
                String licenseBeginStr = fetchAdditionalField(connection, "Veterinarian", "licenseBegin", id);
                Date licenseBegin = (licenseBeginStr != null) ? Date.valueOf(licenseBeginStr) : null;

                String licenseEndStr = fetchAdditionalField(connection, "Veterinarian", "licenseEnd", id);
                Date licenseEnd = (licenseEndStr != null) ? Date.valueOf(licenseEndStr) : null;

                String education = fetchAdditionalField(connection, "Veterinarian", "education", id);
                return new Veterinarian(id, firstName, surname, degBefore, degAfter, null, email, phoneNum, salary, null, userId, encryptedPasswd, null, null, licenseBegin, licenseEnd, education);
            }

            if (isSubclassRecordPresent(connection, "Caretaker", id)) {
                String pavilion = fetchAdditionalField(connection, "Caretaker", "pavilion", id);
                String education = fetchAdditionalField(connection, "Caretaker", "education", id);
                return new Caretaker(id, firstName, surname, degBefore, degAfter, null, email, phoneNum, salary, null, userId, encryptedPasswd, null, null, pavilion, education);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean isSubclassRecordPresent(Connection connection, String tableName, int employeeId) throws SQLException {
        String query = "SELECT 1 FROM " + tableName + " WHERE employee_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    private String fetchAdditionalField(Connection connection, String tableName, String columnName, int employeeId) throws SQLException {
        String query = "SELECT " + columnName + " FROM " + tableName + " WHERE employee_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(columnName);
            }
        }
        return null;
    }
}
