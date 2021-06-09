package ntou.cs.java2021.t4.gordon;

public class OneDayTemperature {
    String weekday;
    String description;
    String temperature;

    public OneDayTemperature(String weekDay, String descrition, String temerature) {
        this.weekday = weekDay;
        this.description = descrition;
        this.temperature = temerature;
    }

    public String getWeekday() {
        return weekday;
    }

    public String getDescription() {
        return description;
    }

    public String getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "OneDayTemperature [weekDay=" + weekday + ", description=" + description + ", temperature=" + temperature
                + "]";
    }

}
