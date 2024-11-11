package lab.FE;

import lab.BE.tables.employees.Employee;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.Node;

public class UserDetailsController extends DetailsController<Employee> {
    
    @FXML
    private Label nameLabel;
    @FXML
    private Label surnameLabel;
    @FXML
    private Label degBeforeLabel;
    @FXML
    private Label degAfterLabel;
    @FXML
    private Label dobLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label phoneNumLabel;
    @FXML
    private Label salaryLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label userIdLabel;
    @FXML
    private Label encryptedPasswdLabel;
    @FXML
    private Label contractBeginLabel;
    @FXML
    private Label contractEndLabel;

    @Override
    protected void displayItemDetails() {
        if (item != null) {
            nameLabel.setText(item.getFirstName() != null ? item.getFirstName() : "Unknown");
            surnameLabel.setText(item.getSurname() != null ? item.getSurname() : "Unknown");
            degBeforeLabel.setText(item.getDegBefore() != null ? item.getDegBefore() : "Unknown");
            degAfterLabel.setText(item.getDegAfter() != null ? item.getDegAfter() : "Unknown");
            dobLabel.setText(item.getDateOfBirth() != null ? item.getDateOfBirth().toString() : "Unknown");
            emailLabel.setText(item.getEmail() != null ? item.getEmail() : "Unknown");
            phoneNumLabel.setText(item.getPhoneNum() != null ? String.join(", ", item.getPhoneNum()) : "Unknown");
            salaryLabel.setText(item.getSalary() != null ? formatSalary(item.getSalary()) : "Unknown");
            addressLabel.setText(item.getAddress() != null ? item.getAddress().toString() : "Unknown");
            userIdLabel.setText(item.getUserId() != null ? item.getUserId() : "Unknown");
            encryptedPasswdLabel.setText(item.getEncryptedPasswd() != null ? "*****" : "Unknown");
            contractBeginLabel.setText(item.getContractBegin() != null ? item.getContractBegin().toString() : "Unknown");
            contractEndLabel.setText(item.getContractEnd() != null ? item.getContractEnd().toString() : "Unknown");
        }
    }

    @Override
    protected Node getPrimaryControl() {
        return nameLabel;
    }

    private String formatSalary(int[] salary) {
        StringBuilder salaryBuilder = new StringBuilder();
        for (int i = 0; i < salary.length; i++) {
            salaryBuilder.append(salary[i]);
            if (i < salary.length - 1) {
                salaryBuilder.append(", ");
            }
        }
        return salaryBuilder.toString();
    }

    public void setUser(Employee employee) {
        this.item = employee;
        displayItemDetails();
    }
}
