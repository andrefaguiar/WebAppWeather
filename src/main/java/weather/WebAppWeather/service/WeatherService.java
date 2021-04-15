package weather.WebAppWeather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import weather.WebAppWeather.domain.Weather;
import weather.WebAppWeather.model.Filter;
import weather.WebAppWeather.model.ResponseItem;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public interface WeatherService {

    List<ResponseItem> getForecastByCity(Filter filter) throws MalformedURLException, URISyntaxException, JsonProcessingException;

}
