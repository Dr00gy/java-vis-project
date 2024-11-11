package lab.BE.tables; // related to the fxml reference

import lab.BE.daos.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Animal implements AnimalComponent {
    private int id_animal; //NOTE: Identity field pattern
    private String pavilion;
    private String name_;
    private Date dateOfBirth;
    private boolean sex;
    private Animal parentOne;
    private Animal parentTwo;
    private String domain_;
    private String phylum;
    private String kingdom;
    private String order_;
    private String suborder;
    private String family_;
    private String genus;
    private String species;
    private Diet diet;
    private Habitat habitat;

    public Animal(int id_animal, String pavilion, String name_, Date dateOfBirth, boolean sex, Animal parentOne, 
                  Animal parentTwo, String domain_, String phylum, String kingdom, String order_, 
                  String suborder, String family_, String genus, String species, Diet diet, Habitat habitat) {
        this.id_animal = id_animal;
        this.pavilion = pavilion;
        this.name_ = name_;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.parentOne = parentOne;
        this.parentTwo = parentTwo;
        this.domain_ = domain_;
        this.phylum = phylum;
        this.kingdom = kingdom;
        this.order_ = order_;
        this.suborder = suborder;
        this.family_ = family_;
        this.genus = genus;
        this.species = species;
        this.diet = diet;
        this.habitat = habitat;
    }

    //overloaded
    public Animal(int id_animal, String name_, String species, boolean sex) {
        this.id_animal = id_animal;
        this.name_ = name_;
        this.species = species;
        this.pavilion = null;
        this.dateOfBirth = null;
        this.sex = true;
        this.parentOne = null;
        this.parentTwo = null;
        this.domain_ = null;
        this.phylum = null;
        this.kingdom = null;
        this.order_ = null;
        this.suborder = null;
        this.family_ = null;
        this.genus = null;
        this.diet = null;
        this.habitat = null;
    }


    public void saveToDatabase() {
        String sql = "INSERT INTO Animal (pavilion, name_, dateOfBirth, sex, parentOne, parentTwo, "
                + "domain_, phylum, kingdom, order_, suborder, family_, genus, species, diet_id, habitat_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             
            statement.setString(1, pavilion);
            statement.setString(2, name_);
            statement.setDate(3, dateOfBirth);
            statement.setBoolean(4, sex);
            statement.setObject(5, parentOne != null ? parentOne.getId() : null);
            statement.setObject(6, parentTwo != null ? parentTwo.getId() : null);
            statement.setString(7, domain_);
            statement.setString(8, phylum);
            statement.setString(9, kingdom);
            statement.setString(10, order_);
            statement.setString(11, suborder);
            statement.setString(12, family_);
            statement.setString(13, genus);
            statement.setString(14, species);
            statement.setObject(15, diet != null ? diet.getId() : null);
            statement.setObject(16, habitat != null ? habitat.getId() : null); 
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public int getId() {
        return id_animal;
    }

    public void setId(int id_animal) {
        this.id_animal = id_animal;
    }

    public String getPavilion() {
        return pavilion;
    }

    public void setPavilion(String pavilion) {
        this.pavilion = pavilion;
    }

    public String getName() {
        return name_;
    }

    public void setName(String name_) {
        this.name_ = name_;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Animal getParentOne() {
        return parentOne;
    }

    public void setParentOne(Animal parentOne) {
        this.parentOne = parentOne;
    }

    public Animal getParentTwo() {
        return parentTwo;
    }

    public void setParentTwo(Animal parentTwo) {
        this.parentTwo = parentTwo;
    }

    public String getDomain() {
        return domain_;
    }

    public void setDomain(String domain_) {
        this.domain_ = domain_;
    }

    public String getPhylum() {
        return phylum;
    }

    public void setPhylum(String phylum) {
        this.phylum = phylum;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getOrder() {
        return order_;
    }

    public void setOrder(String order_) {
        this.order_ = order_;
    }

    public String getSuborder() {
        return suborder;
    }

    public void setSuborder(String suborder) {
        this.suborder = suborder;
    }

    public String getFamily() {
        return family_;
    }

    public void setFamily(String family_) {
        this.family_ = family_;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

        @Override
    public String getAnimalDetails() {
        return "Name: " + name_ + ", Species: " + species;
    }
}
