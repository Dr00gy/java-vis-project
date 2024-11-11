package lab.BE.tables;

public class HealthDocument {
    private int id_health_doc;
    private String diagnosis;
    private String description;
    private String medicine;
    private Animal animal;

    public HealthDocument(int id_health_doc, String diagnosis, String description, String medicine, Animal animal) {
        this.id_health_doc = id_health_doc;
        this.diagnosis = diagnosis;
        this.description = description;
        this.medicine = medicine;
        this.animal = animal;
    }
}
