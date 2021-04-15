package weather.WebAppWeather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseItem {

    private Integer dt;
    private ResponseMain main;
    private List<ResponseWeather> weather;
    private ResponseClouds clouds;
    private ResponseWind wind;
    private ResponseRain rain;

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public ResponseMain getMain() {
        return main;
    }

    public void setMain(ResponseMain main) {
        this.main = main;
    }

    public List<ResponseWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<ResponseWeather> weather) {
        this.weather = weather;
    }

    public ResponseClouds getClouds() {
        return clouds;
    }

    public void setClouds(ResponseClouds clouds) {
        this.clouds = clouds;
    }

    public ResponseWind getWind() {
        return wind;
    }

    public void setWind(ResponseWind wind) {
        this.wind = wind;
    }

    public ResponseRain getRain() {
        return rain;
    }

    public void setRain(ResponseRain rain) {
        this.rain = rain;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    @JsonProperty(value = "dt_txt")
    private String dtTxt;


}
