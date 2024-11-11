package lab.BE.tables;

import java.util.Date;
import org.json.JSONObject;

public class FoodReaction {
    private int id_food_reac;
    private String feedType;
    private String foodItem;
    private int feedAmount;
    private Date dateOfFeed;
    private Date dateOfReaction;
    private JSONObject foodReactionData;
    private HealthDocument healthDocument;

    public FoodReaction(int id_food_reac, String feedType, String foodItem, int feedAmount, Date dateOfFeed, 
                        Date dateOfReaction, JSONObject foodReactionData, HealthDocument healthDocument) {
        this.id_food_reac = id_food_reac;
        this.feedType = feedType;
        this.foodItem = foodItem;
        this.feedAmount = feedAmount;
        this.dateOfFeed = dateOfFeed;
        this.dateOfReaction = dateOfReaction;
        this.foodReactionData = foodReactionData;
        this.healthDocument = healthDocument;
    }
}
