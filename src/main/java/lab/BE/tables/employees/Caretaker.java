package lab.BE.tables.employees;

import java.util.Date;

public class Caretaker extends Employee {
    private String pavilion;
    private String education;

    public Caretaker(int id_emp, String firstName, String surname, String degBefore, String degAfter, 
                     Date dateOfBirth, String email, String[] phoneNum, int[] salary, Address address, 
                     String userId, String encryptedPasswd, Date contractBegin, Date contractEnd, 
                     String pavilion, String education) {
        super(id_emp, firstName, surname, degBefore, degAfter, dateOfBirth, email, phoneNum, salary, address, 
              userId, encryptedPasswd, contractBegin, contractEnd);
        this.pavilion = pavilion;
        this.education = education;
    }

    @Override
    public void login(String user, String encPass) {

    }

    @Override
    public void logout() {

    }
}
