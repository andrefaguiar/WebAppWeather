package weather.WebAppWeather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class ResponseRain {

    @JsonProperty(value = "3h")
    private Double rain3H;

    public Double getRain3H() {
        return rain3H;
    }

    public void setRain3H(Double rain3H) {
        this.rain3H = rain3H;
    }
}
