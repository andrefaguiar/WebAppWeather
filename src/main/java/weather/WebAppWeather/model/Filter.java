package weather.WebAppWeather.model;

import org.springframework.stereotype.Component;

@Component
public class Filter {

    private String name;
    private String country;
    private Integer days;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}
