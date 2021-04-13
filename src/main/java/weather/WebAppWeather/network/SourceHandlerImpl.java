package weather.WebAppWeather.network;

import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "weather")
public class SourceHandlerImpl implements SourceHandler {

    @Value("${weather.source.baseUrl}")
    private final String baseUrl;
    @Value("${weather.API.key}")
    private final String key;
    @Value("${weather.default.city.nameDefault}")
    private final String nameDefault;
    @Value("${weather.default.city.countryDefault}")
    private final String countryDefault;
    @Value("${weather.default.unitDefault}")
    private final String unitDefault;
    @Value("${weather.default.langDefault}")
    private final String langDefault;
    @Value("${weather.default.timestamps.countDefault}")
    private final int countDefault;
    @Value("${weather.3days.timestamps.forecast3day}")
    private final int forecast3day;

    @Autowired
    public SourceHandlerImpl(String baseUrl, String key, String nameDefault, String countryDefault, String unitDefault, String langDefault, int countDefault, int forecast3day) {
        this.baseUrl = baseUrl;
        this.key = key;
        this.nameDefault = nameDefault;
        this.countryDefault = countryDefault;
        this.unitDefault = unitDefault;
        this.langDefault = langDefault;
        this.countDefault = countDefault;
        this.forecast3day = forecast3day;
    }

    public String getURL(String name, String country, int days){
        String cityName = name;
        String countryCod = "," + country;
        int nrCount = countDefault;
        if (name == null ){
            cityName = nameDefault;
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
