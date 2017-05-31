package com.nafeo.www.weatherappproject.DefaultCodes;

import com.nafeo.www.weatherappproject.Models.MyWeatherData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;



public class ParseJson {

    ArrayList<MyWeatherData> arrListMyWeatherData;
    // Parse JSON
     void ParseJson(String data){
        arrListMyWeatherData = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("list");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jobj = jsonArray.getJSONObject(i);

                String date = jobj.getString("dt");
                String pressure = jobj.getString("pressure");
                String humid = jobj.getString("humidity");
                String speed = jobj.getString("speed");

                JSONObject tempObj = jobj.getJSONObject("temp");
                String minTemp = tempObj.getString("min");
                String maxTemp = tempObj.getString("max");

                JSONArray weatherArr = jobj.getJSONArray("weather");
                String desc = weatherArr.getJSONObject(0).getString("description");
                String icon = weatherArr.getJSONObject(0).getString("icon");

                MyWeatherData weatherData = new MyWeatherData(date, minTemp, maxTemp, humid, speed, pressure, desc, icon);

                arrListMyWeatherData.add(weatherData);
            }
        }catch (Exception e){
            e.printStackTrace();}
    }
}
