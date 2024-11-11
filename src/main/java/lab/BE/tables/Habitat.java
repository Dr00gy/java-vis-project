package lab.BE.tables;

public class Habitat {
    private int id_habitat;
    private String pavilion;
    private int sizeX;
    private int sizeY;
    private String environmentType;

    public Habitat(int id_habitat, String pavilion, int sizeX, int sizeY, String environmentType) {
        this.id_habitat = id_habitat;
        this.pavilion = pavilion;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.environmentType = environmentType;
    }

    public int getId() {
        return id_habitat;
    }
}
