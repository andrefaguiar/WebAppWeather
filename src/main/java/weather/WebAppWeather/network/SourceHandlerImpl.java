package weather.WebAppWeather.network;

import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import weather.WebAppWeather.model.Response;

import java.net.URI;
import java.net.URISyntaxException;

@Component
@Configuration
public class SourceHandlerImpl implements SourceHandler {

    @Value("${weather.source.baseUrl}")
    private String baseUrl;
    @Value("${weather.API.key}")
    private String key;
    @Value("${weather.default.city.nameDefault}")
    private String nameDefault;
    @Value("${weather.default.city.countryDefault}")
    private String countryDefault;
    @Value("${weather.default.unitDefault}")
    private String unitDefault;
    @Value("${weather.default.langDefault}")
    private String langDefault;
    @Value("${weather.default.timestamps.countDefault}")
    private int countDefault;
    @Value("${weather.3days.timestamps.forecast3day}")
    private int forecast3day;

    @Autowired
    public SourceHandlerImpl() {
    }

    public String getURL(String name, String country, Integer days){
        String cityName = name;
        String countryCod = "," + country;
        int nrCount = this.countDefault;
        if (name == null ){
            cityName = this.nameDefault;
            countryCod = "," + this.countryDefault;
        }

        if (days == 3) {
            nrCount = this.forecast3day;
        }

        String url = this.baseUrl + "q=" + cityName + countryCod + "&appid=" + key + "&cnt=" + nrCount + "&units=" + unitDefault + "&lang=" + langDefault;

        return url;
    }

    @Override
    public Response getForecast(String name, String country, Integer days) throws URISyntaxException {
        URI url = new URI(getURL(name,country, days));
        return getResponse(url);
    }


    private Response getResponse(URI url){
        HttpEntity<?> request = new HttpEntity<>(null);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Response> response = restTemplate.exchange(url,
                HttpMethod.GET,
                request,
                Response.class);
        return response.getBody();

    }


}
