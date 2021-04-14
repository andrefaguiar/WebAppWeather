package weather.WebAppWeather.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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

    @JsonProperty("dt_txt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dt_txt;

    @JsonProperty("temp")
    private Double temp;

    @JsonProperty("humidity")
    private Long humidity;

    @JsonProperty("weather")
    private String weather;

    @JsonProperty("description")
    private String description;

    @Autowired
    public Weather(Long id, String name, String country, LocalDateTime dt_txt, Double temp, Long humidity, String weather, String description) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.dt_txt = dt_txt;
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

    public LocalDateTime getDt_txt() {
        return dt_txt;
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
