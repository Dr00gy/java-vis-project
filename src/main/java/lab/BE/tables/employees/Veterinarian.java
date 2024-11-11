package lab.BE.tables.employees;

import java.util.Date;

public class Veterinarian extends Employee {
    private Date licenseBegin;
    private Date licenseEnd;
    private String education;

    public Veterinarian(int id_emp, String firstName, String surname, String degBefore, String degAfter, 
                        Date dateOfBirth, String email, String[] phoneNum, int[] salary, Address address, 
                        String userId, String encryptedPasswd, Date contractBegin, Date contractEnd, 
                        Date licenseBegin, Date licenseEnd, String education) {
        super(id_emp, firstName, surname, degBefore, degAfter, dateOfBirth, email, phoneNum, salary, address, 
              userId, encryptedPasswd, contractBegin, contractEnd);
        this.licenseBegin = licenseBegin;
        this.licenseEnd = licenseEnd;
        this.education = education;
    }

    @Override
    public void login(String user, String encryptedPasswd) {

    }

    @Override
    public void logout() {

    }
}
