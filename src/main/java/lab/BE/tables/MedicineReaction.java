package lab.BE.tables;

import java.util.Date;
import org.json.JSONObject;

public class MedicineReaction {
    private int id_med_reac;
    private String medName;
    private int medAmount;
    private Date dateOfMed;
    private Date dateOfReaction;
    private JSONObject medicine_reaction_data;
    private HealthDocument healthDocument;

    public MedicineReaction(int id_med_reac, String medName, int medAmount, Date dateOfMed, Date dateOfReaction, 
                            JSONObject medicine_reaction_data, HealthDocument healthDocument) {
        this.id_med_reac = id_med_reac;
        this.medName = medName;
        this.medAmount = medAmount;
        this.dateOfMed = dateOfMed;
        this.dateOfReaction = dateOfReaction;
        this.medicine_reaction_data = medicine_reaction_data;
        this.healthDocument = healthDocument;
    }
}
