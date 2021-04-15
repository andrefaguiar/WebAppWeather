package weather.WebAppWeather.network;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import weather.WebAppWeather.model.Response;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

@Component
@Configuration
public interface SourceHandler {

    public URI getURL(String name, String country, Integer days) throws UnsupportedEncodingException;

    public Response getForecast(String name, String country, Integer days) throws MalformedURLException, URISyntaxException, UnsupportedEncodingException;

}
