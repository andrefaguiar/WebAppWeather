package weather.WebAppWeather.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import weather.WebAppWeather.domain.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

}
