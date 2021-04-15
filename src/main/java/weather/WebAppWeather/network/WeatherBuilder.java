package weather.WebAppWeather.network;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;
import weather.WebAppWeather.model.Response;
import weather.WebAppWeather.model.ResponseItem;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherBuilder {


    public List<ResponseItem> getForecastArray(Response response) throws JsonProcessingException {
        List<ResponseItem> forecastList = new ArrayList<>();
        forecastList = response.getList();
        return forecastList;
    }

}
