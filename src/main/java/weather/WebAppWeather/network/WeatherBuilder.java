package weather.WebAppWeather.network;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Service;
import weather.WebAppWeather.domain.Weather;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherBuilder {


    public List<Weather> getForecastArray(JSONArray forecast) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String forecastArray = forecast.toJSONString();
        List<Weather> forecastList = new ArrayList<>();
        forecastList = mapper.readValue(forecastArray, new TypeReference<List<Weather>>() { });

        return forecastList;
    }

}
