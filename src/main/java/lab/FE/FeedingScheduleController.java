package lab.FE;

import lab.BE.tables.DietSchedule;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.List;

public class FeedingScheduleController extends FileController {

    private static final String SCHEDULES_JSON_FILE = "jsons/schedules.json";

    @FXML
    private ListView<DietSchedule> scheduleListView;
    @FXML
    private TextField hourField;
    @FXML
    private TextField minuteField;
    @FXML
    private TextField frequencyField;
    @FXML
    private TextField mealTypeField;
    @FXML
    private Button addButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;

    private List<DietSchedule> dietSchedules = new ArrayList<>();

    @Override
    protected String getJsonFilePath() {
        return SCHEDULES_JSON_FILE;
    }

    @FXML
    public void initialize() {
        loadSchedulesFromJson();
        updateScheduleListView();
    }

    private void loadSchedulesFromJson() {
        JsonObject jsonObject = loadJsonFile();
        if (jsonObject == null) return;

        JsonArray jsonSchedules = jsonObject.getAsJsonArray("schedules");

        dietSchedules.clear();
        for (int i = 0; i < jsonSchedules.size(); i++) {
            JsonObject jsonSchedule = jsonSchedules.get(i).getAsJsonObject();
            for (String mealType : new String[]{"breakfast", "lunch", "dinner"}) {
                if (jsonSchedule.has(mealType)) {
                    JsonObject mealJson = jsonSchedule.getAsJsonObject(mealType);
                    int hour = mealJson.get("timeHour").getAsInt();
                    int minute = mealJson.get("timeMin").getAsInt();
                    String frequency = mealJson.get("frequency").getAsString();
                    DietSchedule schedule = new DietSchedule(hour, minute, frequency, mealType);
                    dietSchedules.add(schedule);
                }
            }
        }
    }

    private void saveSchedulesToJson() {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonSchedules = new JsonArray();

        for (DietSchedule schedule : dietSchedules) {
            JsonObject mealJson = new JsonObject();
            mealJson.addProperty("timeHour", schedule.getTimeHour());
            mealJson.addProperty("timeMin", schedule.getTimeMin());
            mealJson.addProperty("frequency", schedule.getFrequency());
            mealJson.addProperty("mealType", schedule.getMealType());
            jsonSchedules.add(mealJson);
        }
        jsonObject.add("schedules", jsonSchedules);
        saveJsonFile(jsonObject);
    }

    @FXML
    private void addSchedule() {
        try {
            int hour = Integer.parseInt(hourField.getText());
            int minute = Integer.parseInt(minuteField.getText());
            String frequency = frequencyField.getText();
            String mealType = mealTypeField.getText();

            DietSchedule newSchedule = new DietSchedule(hour, minute, frequency, mealType);
            dietSchedules.add(newSchedule);
            updateScheduleListView();
            clearFields();
            saveSchedulesToJson();
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter valid hour and minute values.");
        }
    }

    @FXML
    private void updateSchedule() {
        int selectedIndex = scheduleListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            try {
                int hour = Integer.parseInt(hourField.getText());
                int minute = Integer.parseInt(minuteField.getText());
                String frequency = frequencyField.getText();
                String mealType = mealTypeField.getText();

                DietSchedule updatedSchedule = new DietSchedule(hour, minute, frequency, mealType);
                dietSchedules.set(selectedIndex, updatedSchedule);
                updateScheduleListView();
                clearFields();
                saveSchedulesToJson();
            } catch (NumberFormatException e) {
                showAlert("Invalid Input", "Please enter valid hour and minute values.");
            }
        } else {
            showAlert("No Selection", "Please select a schedule to update.");
        }
    }

@FXML
private void deleteSchedule() {
    int selectedIndex = scheduleListView.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {

        DietSchedule removed = dietSchedules.remove(selectedIndex);
        updateScheduleListView();
        saveSchedulesToJson();

        //NOTE: Lambda example here to show an alert 2 tghe user
        showAlert("Schedule Deleted", 
            String.format("%s at %02d:%02d (%s) has been removed.", 
                          removed.getMealType(), 
                          removed.getTimeHour(), 
                          removed.getTimeMin(), 
                          removed.getFrequency()));
    } else {
        showAlert("No Selection", "Please select a schedule to delete.");
    }
}


    private void updateScheduleListView() {
        scheduleListView.getItems().setAll(dietSchedules);
    }

    private void clearFields() {
        hourField.clear();
        minuteField.clear();
        frequencyField.clear();
        mealTypeField.clear();
    }

        @FXML
    private void handleGoBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab/main_page.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) scheduleListView.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            showAlert("Error", "Could not load the main page: " + e.getMessage());
        }
    }
}
