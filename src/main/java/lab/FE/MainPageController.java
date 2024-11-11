package lab.FE;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MainPageController {

    @FXML
    private void handleOpenAnimalForm(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab/animal_form.fxml"));
            AnchorPane animalForm = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(animalForm, 800, 600));
            stage.setTitle("Animal Form");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleOpenAnimalDatabase(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab/all_animals.fxml"));
            AnchorPane allAnimals = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(allAnimals, 800, 600));
            stage.setTitle("Animal Database");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleOpenFeedingSchedule(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab/feeding_schedule.fxml"));
            AnchorPane feedingSchedulePane = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(feedingSchedulePane, 800, 800));
            stage.setTitle("Feeding Schedule");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleOpenHealthDocument(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab/health_document.fxml"));
            AnchorPane healthDocumentPane = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(healthDocumentPane, 800, 800));
            stage.setTitle("Health Document");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     @FXML
    private void handleOpenUserDatabase(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab/all_users.fxml"));
            AnchorPane allUsers = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(allUsers, 800, 600));
            stage.setTitle("User Database");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
