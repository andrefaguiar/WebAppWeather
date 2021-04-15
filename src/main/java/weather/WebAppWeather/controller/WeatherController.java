package weather.WebAppWeather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import weather.WebAppWeather.domain.Weather;
import weather.WebAppWeather.model.Filter;
import weather.WebAppWeather.model.ResponseItem;
import weather.WebAppWeather.service.WeatherService;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(WeatherController.BASE_URL)
public class WeatherController {

    public static final String BASE_URL = "/api/v2/forecast";
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getWeatherForecast(Filter filter){
        try{
            List<ResponseItem> forecastCity = this.weatherService.getForecastByCity(filter);
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
