package lab.FE;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import java.util.List;

public abstract class ListController<T> extends BaseGUIController {

    @FXML
    protected ListView<String> listView;

    protected List<T> items;
    protected int currentPage = 0;
    protected final int itemsPerPage = 2;

    protected abstract List<T> loadData(); // will be implemented by subclasses 2 load data

    @FXML
    public void initialize() {
        items = loadData();
        displayItems();
        
        listView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                handleItemSelected();
            }
        });
    }

    private void displayItems() {
        listView.getItems().clear();
        int startIndex = currentPage * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, items.size());
        for (int i = startIndex; i < endIndex; i++) {
            listView.getItems().add(itemToString(items.get(i)));
        }
    }

    protected abstract String itemToString(T item); // Convert item 2 displayable string

    @FXML
    protected void handlePreviousPage(ActionEvent event) {
        if (currentPage > 0) {
            currentPage--;
            displayItems();
        }
    }

    @FXML
    protected void handleNextPage(ActionEvent event) {
        if ((currentPage + 1) * itemsPerPage < items.size()) {
            currentPage++;
            displayItems();
        }
    }

    protected abstract void handleItemSelected(); // NOTE:
}
