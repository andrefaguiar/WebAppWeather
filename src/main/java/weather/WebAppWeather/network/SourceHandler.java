package weather.WebAppWeather.network;

import net.minidev.json.JSONArray;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@Component
@Configuration
public interface SourceHandler {

    public String getURL(String name, String country, int days);

    public JSONArray getForecast(String name, String country, int days) throws MalformedURLException, URISyntaxException;

}
