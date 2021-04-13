package weather.WebAppWeather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Service;
import weather.WebAppWeather.domain.Weather;
import weather.WebAppWeather.network.SourceHandler;
import weather.WebAppWeather.network.WeatherBuilder;
import weather.WebAppWeather.repositories.WeatherRepository;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService{

    private final WeatherRepository weatherRepository;

    private final SourceHandler sourceHandler;

    private final WeatherBuilder weatherBuilder;

    public WeatherServiceImpl(WeatherRepository weatherRepository, SourceHandler sourceHandler, WeatherBuilder weatherBuilder) {
        this.weatherRepository = weatherRepository;
        this.sourceHandler = sourceHandler;
        this.weatherBuilder = weatherBuilder;
    }


    @Override
    public List<Weather> getForecastByCity(String name, String country, int days) throws MalformedURLException, URISyntaxException, JsonProcessingException {
        JSONArray weatherArray = sourceHandler.getForecast(name, country, days);
        List<Weather> forecastCity = weatherBuilder.getForecastArray(weatherArray);
        return forecastCity;
    }




}
