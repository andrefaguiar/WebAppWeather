package weather.WebAppWeather.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.WebAppWeather.domain.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
