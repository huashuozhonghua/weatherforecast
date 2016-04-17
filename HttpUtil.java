package com.weather.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.weather.entity.CityWeather;

public class HttpUtil
{
	public static CityWeather searchweather(String name) throws Exception
	{
		String httpurl = "http://apis.baidu.com/heweather/weather/free";
		String httpget = httpurl + "?" + "city=" + name;
		BufferedReader reader = null;
		String jsonresult = null;
		CityWeather city = new CityWeather();
		StringBuffer buffer = new StringBuffer();
		URL url = new URL(httpget);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("apikey",
				"8977a7481698da69fb65a02194060442");
		connection.connect();
		InputStream in = connection.getInputStream();
		reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
		String str = null;
		while ((str = reader.readLine()) != null)
		{
			buffer.append(str);
		}
		reader.close();
		jsonresult = buffer.toString();
		JSONObject obj = new JSONObject(jsonresult);
		JSONArray array = obj.getJSONArray("HeWeather data service 3.0");
		JSONObject mcity = array.getJSONObject(0);

		JSONObject basic = mcity.getJSONObject("basic");
		city.setCityid(basic.getString("id"));
		city.setName(basic.getString("city"));
		Log.i("china", basic.toString());

		JSONObject update = basic.getJSONObject("update");
		city.setDate(update.getString("loc"));
		JSONObject aqi = mcity.getJSONObject("aqi");
		JSONObject aqicity = aqi.getJSONObject("city");
		city.setTodayaqiname(aqicity.getString("qlty"));
		city.setTodayaqi(Integer.parseInt(aqicity.getString("aqi")));
		city.setTodaypm25(aqicity.getString("pm25"));
		JSONArray daily = mcity.getJSONArray("daily_forecast");
		Log.i("china", daily.toString());
		JSONObject mcond = daily.getJSONObject(0);
		JSONObject cond = mcond.getJSONObject("cond");
		city.setTodaycondd(cond.getString("txt_d"));
		city.setTodaycondn(cond.getString("txt_n"));
		JSONObject tmp = mcond.getJSONObject("tmp");
		city.setTodaytmpmax(tmp.getString("max"));
		city.setTodaytmpmin(tmp.getString("min"));
		return city;
	}

}
