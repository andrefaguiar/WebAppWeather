package weather.WebAppWeather.service;

import org.springframework.stereotype.Service;
import weather.WebAppWeather.domain.Weather;
import weather.WebAppWeather.network.SourceHandler;
import weather.WebAppWeather.repositories.WeatherRepository;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService{

    private final WeatherRepository weatherRepository;

    private final SourceHandler sourceHandler;

    public WeatherServiceImpl(WeatherRepository weatherRepository, SourceHandler sourceHandler) {
        this.weatherRepository = weatherRepository;
        this.sourceHandler = sourceHandler;
    }

    @Override
    public Optional<Weather> findWeatherByCity(Long id) {
        return weatherRepository.findById(id);
    }

    @Override
    public List<Weather> findAll() {
        return weatherRepository.findAll();
    }

    @Override
    public List<Weather> getForecastByCity(String name, String country, int days) throws MalformedURLException, URISyntaxException {
        sourceHandler.getForecast(name, country, days);
        return null;
    }
}
