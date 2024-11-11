package lab.BE.tables;

import lab.BE.tables.employees.Address;
import lab.BE.tables.AnimalComponent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

public class Foster { //NOTE: Composite
    private int id_foster;
    private String firstName;
    private String surname;
    private String degBefore;
    private String degAfter;
    private Date dateOfBirth;
    private String email;
    private String phoneNum;
    private Address address;
    private List<AnimalComponent> animals;

    public Foster(int id_foster, String firstName, String surname, String degBefore, String degAfter, 
                  Date dateOfBirth, String email, String phoneNum, Address address) {
        this.id_foster = id_foster;
        this.firstName = firstName;
        this.surname = surname;
        this.degBefore = degBefore;
        this.degAfter = degAfter;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(AnimalComponent animal) {
        animals.add(animal);
    }

    public void removeAnimal(AnimalComponent animal) {
        animals.remove(animal);
    }

    public List<AnimalComponent> getAnimals() {
        return animals;
    }

}
