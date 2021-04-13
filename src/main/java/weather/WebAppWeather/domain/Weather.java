package weather.WebAppWeather.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

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

    @JsonPropertyOrder
    private String name;

    @JsonPropertyOrder
    private String country;

    @JsonPropertyOrder
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dt_txt;

    @JsonPropertyOrder
    private Double temp;

    @JsonPropertyOrder
    private Long humidity;

    @JsonPropertyOrder
    private String weather;

    @JsonPropertyOrder
    private String description;



}
