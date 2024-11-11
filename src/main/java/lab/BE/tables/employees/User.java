package lab.BE.tables.employees;

public interface User {
    public void login(String user, String encryptedPasswd);
    public void logout();
}
