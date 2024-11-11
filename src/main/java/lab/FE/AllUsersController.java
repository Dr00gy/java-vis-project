package lab.FE;

import lab.BE.tables.employees.*;
import lab.BE.daos.DatabaseConnection;
import lab.BE.tables.employees.ConcreteEmployee;
import lab.BE.daos.EmployeeDAO;
import lab.BE.exceptions.UserDataAccessException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Array;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collections;

public class AllUsersController extends ListController<Employee> {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

@Override
protected List<Employee> loadData() {
    try {
        return employeeDAO.getAllEmployees();
    } catch (UserDataAccessException e) {
        showAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
        e.printStackTrace();
        return Collections.emptyList();
    }
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

    } catch (Exception e) {
        e.printStackTrace();
        showAlert("Error", "Could not determine the employee type for " + firstName + " " + surname, Alert.AlertType.ERROR);
    }

    return null;
}


    private boolean isSubclassRecordPresent(Connection connection, String tableName, int employeeId) throws Exception {
        String query = "SELECT 1 FROM " + tableName + " WHERE employee_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    private String fetchAdditionalField(Connection connection, String tableName, String columnName, int employeeId) throws Exception {
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

    @Override
    protected String itemToString(Employee user) {
        return user.getFirstName() + " " + user.getSurname();
    }

    @Override
    protected void handleItemSelected() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Employee selectedUser = items.get(selectedIndex);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab/user_details.fxml"));
                AnchorPane detailsPane = loader.load();

                UserDetailsController detailsController = loader.getController();
                detailsController.setUser(selectedUser);

                Stage stage = new Stage();
                stage.setScene(new Scene(detailsPane, 600, 800));
                stage.setTitle("User Details");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
private void handleGoBack() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab/main_page.fxml"));
        AnchorPane mainPage = loader.load();

        Stage stage = (Stage) listView.getScene().getWindow();
        stage.setScene(new Scene(mainPage, 800, 600));
        stage.setTitle("ZOO IS");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
