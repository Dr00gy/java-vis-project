package lab.FE;

import lab.BE.daos.DatabaseConnection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class App extends Application {

    private Connection connection;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            connection = DatabaseConnection.getConnection();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab/main_page.fxml"));
            AnchorPane animalForm = loader.load();
            
            Scene scene = new Scene(animalForm, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.resizableProperty().set(false);
            primaryStage.setTitle("ZOO IS");
            primaryStage.show();

            primaryStage.setOnCloseRequest(this::exitProgram);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exitProgram(WindowEvent evt) {
        //Close the database connection when exiting
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}
