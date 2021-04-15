package weather.WebAppWeather.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Response {

    private String cod;
    private Integer message;
    private Integer cnt;
    private List<ResponseItem> list;
    private ResponseCity city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public List<ResponseItem> getList() {
        return list;
    }

    public void setList(List<ResponseItem> list) {
        this.list = list;
    }

    public ResponseCity getCity() {
        return city;
    }

    public void setCity(ResponseCity city) {
        this.city = city;
    }






}
