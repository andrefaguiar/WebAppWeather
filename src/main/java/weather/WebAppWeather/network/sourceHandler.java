package weather.WebAppWeather.network;

import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class sourceHandler {

    @Value("${Key.weather.source.url}")
    private String baseUrl;

    @Value("${Key.weather.API.key}")
    private String key;



    public JSONArray getForecast(String name, String country, int days){

        url =

        return null;
    }



}
