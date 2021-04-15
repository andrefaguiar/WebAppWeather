package weather.WebAppWeather.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("country")
    private String country;

    @JsonProperty(value = "dt_txt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dtTxt;

    @JsonProperty("temp")
    private Double temp;

    @JsonProperty("humidity")
    private Long humidity;

    @JsonProperty("weather")
    private String weather;

    @JsonProperty("description")
    private String description;

    @Autowired
    public Weather(Long id, String name, String country, LocalDateTime dtTxt, Double temp, Long humidity, String weather, String description) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.dtTxt = dtTxt;
        this.temp = temp;
        this.humidity = humidity;
        this.weather = weather;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public LocalDateTime getDtTxt() {
        return dtTxt;
    }

    public Double getTemp() {
        return temp;
    }

    public Long getHumidity() {
        return humidity;
    }

    public String getWeather() {
        return weather;
    }

    public String getDescription() {
        return description;
    }
}
