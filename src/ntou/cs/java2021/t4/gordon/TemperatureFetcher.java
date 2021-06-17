package ntou.cs.java2021.t4.gordon;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TemperatureFetcher {

    public static final String TARGET_URL = "https://news.pchome.com.tw/weather/taiwan";

    private Map<String, TemperatureBundle> temperatureMap = new LinkedHashMap<String, TemperatureBundle>();

    public TemperatureFetcher() throws IOException {
        fetchAllTemperatureBundles();
    }




    public static void main(String args[]) {
        try {

            TemperatureFetcher fetcher = new TemperatureFetcher();

            // 取得所有城市
            String[] cities = fetcher.getAllCities();
            System.out.println("Cities: " + Arrays.toString(cities));

            // 取得所有城市的氣象資訊Bundle的Map
            Map<String, TemperatureBundle> map = fetcher.getTemperatureMap();

            // 取得單一城市的Bundle
            TemperatureBundle bundle = (TemperatureBundle) map.get("基隆市");

            // 取得一周的"日期"字串
            String[] weekdays = bundle.getWeekdays();
            System.out.println("Days: " + Arrays.toString(weekdays));

            // 取得一天的氣象資訊，包含日期、天氣描述、氣溫
            OneDayTemperature[] oneDayTemperatures = bundle.getOneDayTemperatures();
            String weekday = oneDayTemperatures[0].getWeekday();
            System.out.println("1st Day: " + weekday);
            String description = oneDayTemperatures[0].getDescription();
            System.out.println("Description: " + description);
            String temperature = oneDayTemperatures[0].getTemperature();
            System.out.println("Temperature: " + temperature);

        } catch (IOException ie) {
            System.err.println(ie);
        }
    }

    // 取得所有天氣資訊，並存放於Map
    public final void fetchAllTemperatureBundles() throws IOException {
        // File input = new File("weather.html");

        Connection.Response res = Jsoup.connect(TARGET_URL).timeout(5000)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0")
                .method(Method.GET).execute();
        Document doc = res.parse();
        Elements zones = doc.select(".weather-table");

        for (Element zone : zones) {
            String city = zone.select("div.nationpart").text();
            TemperatureBundle temperatureBundle = new TemperatureBundle(city);
            OneDayTemperature[] oneDayTemperatures = new OneDayTemperature[7];

            Elements oneDayWeathers = zone.select("ul.weather-cell li");
            int number = 0;
            for (Element oneDayWeather : oneDayWeathers) {
                String weekDay = oneDayWeather.select(".day span").text();
                weekDay = weekDay.replace("/ ", " (") + ")";
                String description = oneDayWeather.select("p.temp_s em.cond").text();
                String temperature = oneDayWeather.select("p.temp_s span").text();
                temperature = temperature.replace(" /", " ~ ");
                OneDayTemperature oneDayTemperature = new OneDayTemperature(weekDay, description, temperature);
                oneDayTemperatures[number++] = oneDayTemperature;
            }

            temperatureBundle.setOneDayTemperatures(oneDayTemperatures);
            temperatureMap.put(city, temperatureBundle);
        }
    }

    public Map<String, TemperatureBundle> getTemperatureMap() {
        return temperatureMap;
    }

    public String[] getAllCities() {
        Object[] keys = temperatureMap.keySet().toArray();
        String[] cityNames = new String[keys.length];
        int number = 0;
        for (Object key : keys) {
            cityNames[number++] = (String) key;
        }
        return cityNames;
    }
}
