package lab.FE;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.List;

import lab.BE.observer.Observer;
import lab.BE.observer.Subject;
import lab.BE.daos.EmployeeDAO;
import lab.BE.tables.employees.Employee;
import lab.BE.tables.employees.ConcreteEmployee;
import lab.BE.exceptions.UserDataAccessException;

public class HealthDocumentController extends FileController implements Subject { //NOTE: Observer pattern

    private static final String REACTIONS_JSON_FILE = "jsons/medicine_reactions.json";

    @FXML
    private ListView<JsonObject> reactionListView;
    @FXML
    private CheckBox weightLossCheckBox;
    @FXML
    private CheckBox weightGainCheckBox;
    @FXML
    private CheckBox digestionProblemCheckBox;
    @FXML
    private CheckBox vomitCheckBox;
    @FXML
    private CheckBox allergyCheckBox;
    @FXML
    private CheckBox bleedingCheckBox;
    @FXML
    private CheckBox curedCheckBox;

    private List<JsonObject> medicineReactions = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    protected String getJsonFilePath() {
        return REACTIONS_JSON_FILE;
    }

    @FXML
    public void initialize() {
        loadReactionsFromJson();
        updateReactionListView();
        registerEmployees(loadEmployees());
    }

    private void loadReactionsFromJson() {
        JsonObject jsonObject = loadJsonFile();
        if (jsonObject == null) return;

        JsonArray jsonReactions = jsonObject.getAsJsonArray("medicine_reactions");
        medicineReactions.clear();

        for (int i = 0; i < jsonReactions.size(); i++) {
            JsonObject reactionJson = jsonReactions.get(i).getAsJsonObject();
            medicineReactions.add(reactionJson); // directly add the reaction JsonObject
        }
    }

    private void saveReactionsToJson() {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonReactions = new JsonArray();

        for (JsonObject reaction : medicineReactions) {
            jsonReactions.add(reaction);
        }

        jsonObject.add("medicine_reactions", jsonReactions);
        saveJsonFile(jsonObject);
    }

        @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    @FXML
    private void addReaction() {
        JsonObject newReaction = new JsonObject();
        newReaction.addProperty("weight_loss", weightLossCheckBox.isSelected());
        newReaction.addProperty("weight_gain", weightGainCheckBox.isSelected());
        newReaction.addProperty("digestion_problem", digestionProblemCheckBox.isSelected());
        newReaction.addProperty("vomit", vomitCheckBox.isSelected());
        newReaction.addProperty("allergy", allergyCheckBox.isSelected());
        newReaction.addProperty("bleeding", bleedingCheckBox.isSelected());
        newReaction.addProperty("cured", curedCheckBox.isSelected());

        medicineReactions.add(newReaction);
        updateReactionListView();
        clearFields();
        saveReactionsToJson();
    }

    @FXML
    private void updateReaction() {
        int selectedIndex = reactionListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            JsonObject updatedReaction = new JsonObject();
            updatedReaction.addProperty("weight_loss", weightLossCheckBox.isSelected());
            updatedReaction.addProperty("weight_gain", weightGainCheckBox.isSelected());
            updatedReaction.addProperty("digestion_problem", digestionProblemCheckBox.isSelected());
            updatedReaction.addProperty("vomit", vomitCheckBox.isSelected());
            updatedReaction.addProperty("allergy", allergyCheckBox.isSelected());
            updatedReaction.addProperty("bleeding", bleedingCheckBox.isSelected());
            updatedReaction.addProperty("cured", curedCheckBox.isSelected());

            medicineReactions.set(selectedIndex, updatedReaction);
            updateReactionListView();
            clearFields();
            saveReactionsToJson();
            notifyObservers("A medicine reaction has been updated.");
        } else {
            showAlert("No Selection", "Please select a reaction to update.");
        }
    }

    @FXML
    private void deleteReaction() {
        int selectedIndex = reactionListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            medicineReactions.remove(selectedIndex);
            updateReactionListView();
            saveReactionsToJson();
        } else {
            showAlert("No Selection", "Please select a reaction to delete.");
        }
    }

    private void updateReactionListView() {
        reactionListView.getItems().clear();
        reactionListView.getItems().addAll(medicineReactions);
    }

    private void clearFields() {
        weightLossCheckBox.setSelected(false);
        weightGainCheckBox.setSelected(false);
        digestionProblemCheckBox.setSelected(false);
        vomitCheckBox.setSelected(false);
        allergyCheckBox.setSelected(false);
        bleedingCheckBox.setSelected(false);
        curedCheckBox.setSelected(false);
    }
    
        @FXML
    private void handleGoBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab/main_page.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) reactionListView.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            showAlert("Error", "Could not load the main page: " + e.getMessage());
        }
    }

private List<Employee> loadEmployees() {
    try {
        return employeeDAO.getAllEmployees();
    } catch (UserDataAccessException e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
}


public void registerEmployees(List<Employee> employees) {
    for (Employee employee : employees) {
        registerObserver(employee);
    }
}
}
