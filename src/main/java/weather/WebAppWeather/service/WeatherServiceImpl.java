package weather.WebAppWeather.service;

import org.springframework.stereotype.Service;
import weather.WebAppWeather.domain.Weather;
import weather.WebAppWeather.repositories.WeatherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService{

    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
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
    public List<Weather> getForecastByCity(String name, String country, int days) {
        return null;
    }
}
