package weather.WebAppWeather.service;

import org.springframework.stereotype.Service;
import weather.WebAppWeather.domain.Weather;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public interface WeatherService {

    Optional<Weather> findWeatherByCity(Long id);

    List<Weather> findAll();

    List<Weather> getForecastByCity(String name, String country, int days) throws MalformedURLException, URISyntaxException;

}
