package weather.WebAppWeather.network;

import net.minidev.json.JSONArray;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@Service
public interface SourceHandler {

    public String getURL(String name, String country, int days);

    public JSONArray getForecast(String name, String country, int days) throws MalformedURLException, URISyntaxException;

}
