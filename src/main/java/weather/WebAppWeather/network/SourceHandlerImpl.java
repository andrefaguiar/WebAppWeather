package weather.WebAppWeather.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import weather.WebAppWeather.model.Response;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;

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
    private Integer countDefault;
    @Value("${weather.3days.timestamps.forecast3day}")
    private Integer forecast3day;

    @Autowired
    public SourceHandlerImpl() {
    }

    public URI getURL(String name, String country, Integer days) throws UnsupportedEncodingException {
        String cityName = name;
        String countryCod = "," + country;
        Integer nrCount = this.forecast3day;
        if (name == null ){
            cityName = this.nameDefault;
            countryCod = "," + this.countryDefault;
        }

        if (days == null || days != 3) {
            nrCount = this.countDefault;
        }

        if (country == null){
            countryCod = "";
        }

//        String urlString = this.baseUrl + "q=" + cityName + countryCod + "&appid=" + key + "&cnt=" + nrCount + "&units=" + unitDefault + "&lang=" + langDefault;

        URI url = UriComponentsBuilder
                .fromHttpUrl(this.baseUrl)
                .queryParam("q", cityName + countryCod)
                .queryParam("appid", this.key)
                .queryParam("cnt", nrCount)
                .queryParam("units", this.unitDefault)
                .queryParam("lang", this.langDefault)
                .encode()
                .build()
                .toUri();

        return url;
    }

    @Override
    public Response getForecast(String name, String country, Integer days) throws URISyntaxException, UnsupportedEncodingException {
//        URI url = new URI(getURL(name, country, days));
        return getResponse(getURL(name, country, days));
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
