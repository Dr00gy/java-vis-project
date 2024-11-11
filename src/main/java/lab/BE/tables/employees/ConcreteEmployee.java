package lab.BE.tables.employees;

import java.util.Date;

public class ConcreteEmployee extends Employee {

    public ConcreteEmployee(int id_emp, String firstName, String surname, String degBefore, String degAfter, 
                            Date dateOfBirth, String email, String[] phoneNum, int[] salary, Address address, 
                            String userId, String encryptedPasswd, Date contractBegin, Date contractEnd) {
        super(id_emp, firstName, surname, degBefore, degAfter, dateOfBirth, email, phoneNum, salary, address, 
              userId, encryptedPasswd, contractBegin, contractEnd);
    }

    @Override
    public void login(String user, String encryptedPasswd) {

    }

    @Override
    public void logout() {

    }
}
