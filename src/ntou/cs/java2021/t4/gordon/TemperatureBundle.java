package ntou.cs.java2021.t4.gordon;

import java.util.Arrays;

public class TemperatureBundle {
    private String location; // 地理區域名稱 (如臺北市、基隆市)
    private String[] weekdays;
    private OneDayTemperature[] oneDayTemperatures;

    public TemperatureBundle(String location) {
        this.location = location;
    }

    public TemperatureBundle(String location, OneDayTemperature[] oneDayTemperatures) {
        this.location = location;
        this.oneDayTemperatures = oneDayTemperatures;
        this.setWeekdays();
    }

    public String getLocation() {
        return location;
    }

    public OneDayTemperature[] getOneDayTemperatures() {
        return oneDayTemperatures;
    }

    public void setOneDayTemperatures(OneDayTemperature[] oneDayTemperatures) {
        this.oneDayTemperatures = oneDayTemperatures;
        setWeekdays();
    }

    private final void setWeekdays() {
        String[] days = new String[7];
        int number = 0;
        for (OneDayTemperature oneDayTemperature : oneDayTemperatures) {
            days[number++] = oneDayTemperature.getWeekday();
        }
        this.weekdays = days;
    }

    public String[] getWeekdays() {
        return weekdays;
    }

    @Override
    public String toString() {
        return "TemperatureBundle [location=" + location + ", weekDays=" + Arrays.toString(weekdays)
                + ", oneDayTemperatures=" + Arrays.toString(oneDayTemperatures) + "]";
    }
}
