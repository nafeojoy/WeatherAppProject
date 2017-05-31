package com.nafeo.www.weatherappproject.Models;



public class MyWeatherData {
    String dt;
    String min;
    String max;
    String humidity;
    String speed;
    String pressure;
    String description;
    String icon;


    public MyWeatherData(String dt, String min, String max, String humidity, String speed, String pressure, String description, String icon) {
        this.dt = dt;
        this.min = min;
        this.max = max;
        this.humidity = humidity;
        this.speed = speed;
        this.pressure = pressure;
        this.description = description;
        this.icon = icon;

    }

    public String getDt() {
        return dt;
    }


    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
