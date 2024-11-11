package lab.FE;

import lab.BE.tables.Animal;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.Node;

public class AnimalDetailsController extends DetailsController<Animal> {
    
    @FXML
    private Label nameLabel;
    @FXML
    private Label speciesLabel;
    @FXML
    private Label pavilionLabel;
    @FXML
    private Label dobLabel;
    @FXML
    private Label sexLabel;
    @FXML
    private Label parentOneLabel;
    @FXML
    private Label parentTwoLabel;
    @FXML
    private Label domainLabel;
    @FXML
    private Label phylumLabel;
    @FXML
    private Label kingdomLabel;
    @FXML
    private Label orderLabel;
    @FXML
    private Label suborderLabel;
    @FXML
    private Label familyLabel;
    @FXML
    private Label genusLabel;
    @FXML
    private Label dietLabel;
    @FXML
    private Label habitatLabel;

    @Override
    protected void displayItemDetails() {
        if (item != null) {
            nameLabel.setText(item.getName() != null ? item.getName() : "Unknown");
            sexLabel.setText(item.isSex() ? "Male" : "Female");
            speciesLabel.setText(item.getSpecies() != null ? item.getSpecies() : "Unknown");
            pavilionLabel.setText(item.getPavilion() != null ? item.getPavilion() : "Unknown");
            dobLabel.setText(item.getDateOfBirth() != null ? item.getDateOfBirth().toString() : "Unknown");
            domainLabel.setText(item.getDomain() != null ? item.getDomain() : "Unknown");
            phylumLabel.setText(item.getPhylum() != null ? item.getPhylum() : "Unknown");
            kingdomLabel.setText(item.getKingdom() != null ? item.getKingdom() : "Unknown");
            orderLabel.setText(item.getOrder() != null ? item.getOrder() : "Unknown");
            suborderLabel.setText(item.getSuborder() != null ? item.getSuborder() : "Unknown");
            familyLabel.setText(item.getFamily() != null ? item.getFamily() : "Unknown");
            genusLabel.setText(item.getGenus() != null ? item.getGenus() : "Unknown");
            parentOneLabel.setText(item.getParentOne() != null ? item.getParentOne().getName() : "Unknown");
            parentTwoLabel.setText(item.getParentTwo() != null ? item.getParentTwo().getName() : "Unknown");
            dietLabel.setText(item.getDiet() != null ? "Placeholder" : "Unknown");
            habitatLabel.setText(item.getHabitat() != null ? "Placeholder" : "Unknown");
        }
    }

    public void setAnimal(Animal animal) {
        this.item = animal;
        displayItemDetails();
    }

    @Override
    protected Node getPrimaryControl() {
        return nameLabel;
    }
}
