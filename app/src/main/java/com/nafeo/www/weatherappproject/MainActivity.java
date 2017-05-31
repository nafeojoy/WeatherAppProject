package com.nafeo.www.weatherappproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import com.nafeo.www.weatherappproject.Adapters.MyAdapter;
import com.nafeo.www.weatherappproject.DefaultCodes.GetDataFromUrl;
import com.nafeo.www.weatherappproject.DefaultCodes.ParseJson;
import com.nafeo.www.weatherappproject.Models.MyWeatherData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.nafeo.www.weatherappproject.DefaultCodes.GetDataFromUrl.urlAPI;

public class MainActivity extends AppCompatActivity {

    String dataResponse;
    ArrayList<MyWeatherData> arrListMyWeatherData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetDataAsyncTask().execute();
    }

    // Parse JSON
    void parseJson(String data){
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



    public class GetDataAsyncTask extends AsyncTask<Void, Void, Void>{


        @Override
        protected Void doInBackground(Void... params) {

            dataResponse = GetDataFromUrl.getDataFromUrl(urlAPI);
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            parseJson(dataResponse);
            ListView listV = (ListView ) findViewById(R.id.list);
            MyAdapter adapter = new MyAdapter(MainActivity.this,arrListMyWeatherData);
            listV.setAdapter(adapter);
        }
    }
}
