package lab.FE;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class FileController { //NOTE: Simutaneously Gateway (in feeding schedule and health doc)

    protected abstract String getJsonFilePath();

    protected JsonObject loadJsonFile() {
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader(getJsonFilePath()))) {
            return gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            showAlert("Error", "Failed to load file: " + e.getMessage());
            return null;
        }
    }

    protected void saveJsonFile(JsonObject jsonObject) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(getJsonFilePath())) {
            gson.toJson(jsonObject, writer);
        } catch (IOException e) {
            showAlert("Error", "Failed to save file: " + e.getMessage());
        }
    }

    protected void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
