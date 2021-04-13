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
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/{city},{country},{days}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getWeatherForecast(@RequestParam("cityId") String cityId,
                                                     @RequestParam("country") String country,
                                                     @RequestParam("days") int days){
        try{
            List<Weather> forecastCity = weatherService.getForecastByCity(cityId, country,days);
            if (forecastCity.size() > 0){
                return new ResponseEntity<>(forecastCity, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return null;
    }


}
