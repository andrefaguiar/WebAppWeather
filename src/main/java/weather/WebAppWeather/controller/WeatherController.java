package weather.WebAppWeather.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import weather.WebAppWeather.domain.Weather;
import weather.WebAppWeather.service.WeatherService;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(WeatherController.BASE_URL)
public class WeatherController {

    public static final String BASE_URL = "/api/v2/forecast";
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/{name},{country},{days}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getWeatherForecast(@RequestParam("name") String name,
                                                     @RequestParam("country") String country,
                                                     @RequestParam("days") int days){
        try{
            List<Weather> forecastCity = weatherService.getForecastByCity(name, country, days);
            if (forecastCity.size() > 0){
                return new ResponseEntity<>(forecastCity, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return null;
    }


}
