package lab.BE.tables.employees;

public class Address {
    private int id_add;
    private String street;
    private String city;
    private String region;
    private String postal;
    private String country;

    public Address(int id_add, String street, String city, String region, String postal, String country) {
        this.id_add = id_add;
        this.street = street;
        this.city = city;
        this.region = region;
        this.postal = postal;
        this.country = country;
    }
}
