package lab.FE;

import lab.BE.tables.Animal;
import lab.BE.daos.AnimalDAO;
import lab.BE.exceptions.AnimalDataAccessException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class AllAnimalsController extends ListController<Animal> {

    private AnimalDAO animalDAO = new AnimalDAO();

    @Override
    protected List<Animal> loadData() {
        try {
            return animalDAO.getAllAnimals();
        } catch (AnimalDataAccessException e) {
            showAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    protected String itemToString(Animal animal) {
        return animal.getName() + " (" + animal.getSpecies() + ")";
    }

    @Override
    protected void handleItemSelected() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Animal selectedAnimal = items.get(selectedIndex);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab/animal_details.fxml"));
                AnchorPane detailsPane = loader.load();

                AnimalDetailsController detailsController = loader.getController();
                detailsController.setAnimal(selectedAnimal);

                Stage stage = new Stage();
                stage.setScene(new Scene(detailsPane, 600, 800));
                stage.setTitle("Animal Details");
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
