package weather.WebAppWeather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weather.WebAppWeather.domain.Weather;
import weather.WebAppWeather.model.Filter;
import weather.WebAppWeather.model.Response;
import weather.WebAppWeather.model.ResponseItem;
import weather.WebAppWeather.network.SourceHandler;
import weather.WebAppWeather.network.WeatherBuilder;
import weather.WebAppWeather.repositories.WeatherRepository;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService{

    private final WeatherRepository weatherRepository;

    private final SourceHandler sourceHandler;

    private final WeatherBuilder weatherBuilder;

    @Autowired
    public WeatherServiceImpl(WeatherRepository weatherRepository, SourceHandler sourceHandler, WeatherBuilder weatherBuilder) {
        this.weatherRepository = weatherRepository;
        this.sourceHandler = sourceHandler;
        this.weatherBuilder = weatherBuilder;
    }


    @Override
    public List<ResponseItem> getForecastByCity(Filter filter) throws MalformedURLException, URISyntaxException, JsonProcessingException, UnsupportedEncodingException {
        Response response = this.sourceHandler.getForecast(filter.getName(), filter.getCountry(), filter.getDays());
        return this.weatherBuilder.getForecastArray(response);
    }




}
