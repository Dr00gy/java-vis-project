package lab.BE.tables.employees;
import lab.BE.observer.Observer;

import java.util.Date;
import java.sql.Array;
import java.util.Arrays;


public abstract class Employee implements User, Observer { //NOTE: Domain model
    protected int id_emp;
    protected String firstName;
    protected String surname;
    protected String degBefore;
    protected String degAfter;
    protected Date dateOfBirth;
    protected String email;
    protected String[] phoneNum;
    protected int[] salary;
    protected Address address;
    protected String userId;
    protected String encryptedPasswd;
    protected Date contractBegin;
    protected Date contractEnd;

    public Employee(int id_emp, String firstName, String surname, String degBefore, String degAfter, 
                    Date dateOfBirth, String email, String[] phoneNum, int[] salary, Address address, 
                    String userId, String encryptedPasswd, Date contractBegin, Date contractEnd) {
        this.id_emp = id_emp;
        this.firstName = firstName;
        this.surname = surname;
        this.degBefore = degBefore;
        this.degAfter = degAfter;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.address = address;
        this.userId = userId;
        this.encryptedPasswd = encryptedPasswd;
        this.contractBegin = contractBegin;
        this.contractEnd = contractEnd;
    }

    //overloaded
    public Employee(int id_emp, String firstName, String surname) {
        this.id_emp = id_emp;
        this.firstName = firstName;
        this.surname = surname;
        this.degBefore = null;
        this.degAfter = null;
        this.dateOfBirth = null;
        this.email = null;
        this.phoneNum = null;
        this.salary = null; //NOTE: array
        this.address = null;
        this.userId = null;
        this.encryptedPasswd = null;
        this.contractBegin = null;
        this.contractEnd = null;
    }

    public int getIdEmp() {
        return id_emp;
    }

    public void setIdEmp(int id_emp) {
        this.id_emp = id_emp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDegBefore() {
        return degBefore;
    }

    public void setDegBefore(String degBefore) {
        this.degBefore = degBefore;
    }

    public String getDegAfter() {
        return degAfter;
    }

    public void setDegAfter(String degAfter) {
        this.degAfter = degAfter;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String[] phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int[] getSalary() {
        return salary;
    }

    public void setSalary(int[] salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEncryptedPasswd() {
        return encryptedPasswd;
    }

    public void setEncryptedPasswd(String encryptedPasswd) {
        this.encryptedPasswd = encryptedPasswd;
    }

    public Date getContractBegin() {
        return contractBegin;
    }

    public void setContractBegin(Date contractBegin) {
        this.contractBegin = contractBegin;
    }

    public Date getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(Date contractEnd) {
        this.contractEnd = contractEnd;
    }

        @Override
    public void update(String message) {
        System.out.println("Employee " + firstName + " " + surname + ": " + message);
    }
}