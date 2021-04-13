package weather.WebAppWeather.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import weather.WebAppWeather.service.WeatherService;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }



    @GetMapping(value = "/{city}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getWeatherForecast(@RequestParam("cityId") String cityId){



//        try {
//            ForecastDTO forecastDTO = weatherService.getForecast("cityId");
//            if (forecastDTO.getForecast("cityId").size() > 0) {
//                return  new ResponseEntity<>(forecastDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e){
//            return new ResponseEntity<>(new ErrorDTO(e), HttpStatus.CONFLICT);
//        }
        return null;
    }


}
