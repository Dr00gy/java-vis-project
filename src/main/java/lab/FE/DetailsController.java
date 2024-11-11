package lab.FE;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public abstract class DetailsController<T> extends BaseGUIController {

    protected T item;

    public void setItem(T item) {
        this.item = item;
        displayItemDetails();
    }

    protected abstract void displayItemDetails(); // NOTE:

    @FXML
    private void handleClose(ActionEvent event) {
        Stage stage = (Stage) getPrimaryControl().getScene().getWindow();
        stage.close();
    }

    protected abstract javafx.scene.Node getPrimaryControl(); //Get primary control 4 window stage retrieval
}
