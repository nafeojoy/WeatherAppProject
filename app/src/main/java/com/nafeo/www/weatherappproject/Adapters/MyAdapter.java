package com.nafeo.www.weatherappproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nafeo.www.weatherappproject.Models.MyWeatherData;
import com.nafeo.www.weatherappproject.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MyAdapter extends BaseAdapter {

    Context c;
    ArrayList<MyWeatherData> arrListMyWeatherData;

    public MyAdapter(Context c, ArrayList<MyWeatherData> arrListMyWeatherData) {
        this.c = c;
        this.arrListMyWeatherData = arrListMyWeatherData;
    }

    @Override
    public int getCount() {
        return arrListMyWeatherData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)
                c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.week_weather_list, parent, false);

        TextView dateWeek = (TextView) view.findViewById(R.id.dateWeek);
        TextView weather = (TextView) view.findViewById(R.id.weather);
        TextView minTemp = (TextView) view.findViewById(R.id.minTemp);
        TextView maxTemp = (TextView) view.findViewById(R.id.maxTemp);

        ImageView logoWeather = (ImageView) view.findViewById(R.id.logoWeather);

        Date createdOn = new Date(Long.parseLong(arrListMyWeatherData.get(position).getDt()));
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String formattedDate = sdf.format(createdOn);

        dateWeek.setText(formattedDate.toString());
        weather.setText(arrListMyWeatherData.get(position).getDescription());
        minTemp.setText(arrListMyWeatherData.get(position).getMin()+(char) 0x00B0);
        maxTemp.setText(arrListMyWeatherData.get(position).getMax()+(char) 0x00B0);

        logoWeather.setImageResource(R.mipmap.ic_launcher);

        return view;
    }
}
