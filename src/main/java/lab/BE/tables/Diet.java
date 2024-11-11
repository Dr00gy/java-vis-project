package lab.BE.tables;

import org.json.JSONObject;
import java.util.List;

public class Diet {
    private int id_diet;
    private String feedType;
    private int foodAmount;
    private String foodItem;
    private List<DietSchedule> schedule;

    public Diet(int id_diet, String feedType, int foodAmount, String foodItem, List<DietSchedule> schedule) {
        this.id_diet = id_diet;
        this.feedType = feedType;
        this.foodAmount = foodAmount;
        this.foodItem = foodItem;
        this.schedule = schedule;
    }

    public int getId() {
        return id_diet;
    }

    public void setId(int id_diet) {
        this.id_diet = id_diet;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public List<DietSchedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<DietSchedule> schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Diet{" +
               "id_diet=" + id_diet +
               ", feedType='" + feedType + '\'' +
               ", foodAmount=" + foodAmount +
               ", foodItem='" + foodItem + '\'' +
               ", schedule=" + schedule +
               '}';
    }
}
