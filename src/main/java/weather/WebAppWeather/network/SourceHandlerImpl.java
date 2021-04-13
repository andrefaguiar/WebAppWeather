package weather.WebAppWeather.network;

import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class SourceHandlerImpl implements SourceHandler {

    @Value("${application.weather.source.url}")
    private String baseUrl;
    @Value("${application.weather.API.key}")
    private String key;
    @Value("${application.weather.deafult.city.name}")
    private String cityDefault;
    @Value("${application.weather.deafult.city.country}")
    private String countryDefault;
    @Value("${application.weather.deafult.unit}")
    private String unitDefault;
    @Value("${application.weather.deafult.language}")
    private String langDefault;
    @Value("${application.weather.deafult.timesatmps.count}")
    private int countDeafult;
    @Value("${application.weather.3days.timesatmps.count}")
    private int forecast3day;

    public String getURL(String name, String country, int days){
        String cityName = name;
        String countryCod = "," + country;
        int nrCount = countDeafult;
        if (name == null ){
            cityName = cityDefault;
            countryCod = "," + countryDefault;
        }

        if (days == 3) {
            nrCount = forecast3day;
        }

        String url = baseUrl + "q=" + cityName + countryCod + "&appid=" + key + "&cnt=" + nrCount + "&units=" + unitDefault + "&lang=" + langDefault;

        return url;
    }

    @Override
    public JSONArray getForecast(String name, String country, int days) throws URISyntaxException {
        URI url = new URI(getURL(name,country, days));
        JSONArray forecastArray = new JSONArray();
        return forecastArray = getResponse(url, JSONArray.class);
    }


    private <T> T getResponse(URI url, Class<T> responseType){
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> response = restTemplate.exchange(request, responseType);
        return response.getBody();

    }


}
