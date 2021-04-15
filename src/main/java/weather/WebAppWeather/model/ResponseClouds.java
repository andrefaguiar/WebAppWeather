package weather.WebAppWeather.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseClouds {

    private Integer all;

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }
}
