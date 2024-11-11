package lab.FE;

import lab.BE.tables.Animal;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

import java.sql.Date;

public class AnimalController {
    @FXML
    private TextField pavilionField;
    @FXML
    private TextField nameField;
    @FXML
    private DatePicker dateOfBirthPicker;
    @FXML
    private CheckBox sexField;
    @FXML
    private TextField domainField;
    @FXML
    private TextField phylumField;
    @FXML
    private TextField kingdomField;
    @FXML
    private TextField orderField;
    @FXML
    private TextField suborderField;
    @FXML
    private TextField familyField;
    @FXML
    private TextField genusField;
    @FXML
    private TextField speciesField;

    @FXML
    private void handleSubmit() {
        try {
            String pavilion = pavilionField.getText();
            String name_ = nameField.getText();
            Date dateOfBirth = Date.valueOf(dateOfBirthPicker.getValue());
            boolean sex = sexField.isSelected(); // true for male, false for female
            String domain_ = domainField.getText();
            String phylum = phylumField.getText();
            String kingdom = kingdomField.getText();
            String order_ = orderField.getText();
            String suborder = suborderField.getText();
            String family_ = familyField.getText();
            String genus = genusField.getText();
            String species = speciesField.getText();

            Animal animal = new Animal(0, pavilion, name_, dateOfBirth, sex, null, null, domain_, phylum, 
                                        kingdom, order_, suborder, family_, genus, species, null, null);
            animal.saveToDatabase();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Animal saved successfully!");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save animal: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void handleGoBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab/main_page.fxml"));
            AnchorPane mainPage = loader.load();

            Stage stage = (Stage) pavilionField.getScene().getWindow();
            stage.setScene(new Scene(mainPage, 800, 600));
            stage.setTitle("ZOO IS");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
