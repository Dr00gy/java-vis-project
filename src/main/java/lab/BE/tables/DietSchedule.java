package lab.BE.tables;

public class DietSchedule {
    private int timeHour;
    private int timeMin;
    private String frequency;
    private String mealType;

    public DietSchedule(int timeHour, int timeMin, String frequency, String mealType) {
        this.timeHour = timeHour;
        this.timeMin = timeMin;
        this.frequency = frequency;
        this.mealType = mealType;
    }

    public int getTimeHour() {
        return timeHour;
    }

    public void setTimeHour(int timeHour) {
        this.timeHour = timeHour;
    }

    public int getTimeMin() {
        return timeMin;
    }

    public void setTimeMin(int timeMin) {
        this.timeMin = timeMin;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    @Override
    public String toString() {
        return "DietSchedule{" +
               "timeHour=" + timeHour +
               ", timeMin=" + timeMin +
               ", frequency='" + frequency + '\'' +
               ", mealType='" + mealType + '\'' +
               '}';
    }
}
