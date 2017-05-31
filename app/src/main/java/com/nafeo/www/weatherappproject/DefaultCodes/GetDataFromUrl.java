package com.nafeo.www.weatherappproject.DefaultCodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



 public class GetDataFromUrl {
     public static String urlAPI = "http://api.openweathermap.org/data/2.5/forecast/daily?APPID=e361c6ae553dc2faf9364cd13b1bc038&q=Dhaka&mode=json&units=metric&cnt=7";

     //Get Data from URl (Universal Code)
      public static String getDataFromUrl(String url){
        String line = "";
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL urls = new URL(url);
            connection = (HttpURLConnection) urls.openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(stream);
            reader = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                buffer.append(line);

            }
            return buffer.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return line;
    }
}
