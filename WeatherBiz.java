package com.weather.dal;

import com.weather.entity.CityWeather;
import com.weather.util.DBUtil;
import com.weather.util.HttpUtil;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class WeatherBiz extends AsyncTask<String, Void, CityWeather>
{
	turnBack turnback;
	Context context;
	DBUtil bdutil;

	public WeatherBiz(turnBack turnback, Context context)
	{
		this.turnback = turnback;
		this.context = context;
	}

	@Override
	protected CityWeather doInBackground(String... params)
	{
		String cityname = params[0];
		CityWeather city = new CityWeather();
		try
		{
			Log.i("china", "doInBackgrounddoInBackground");
			city = HttpUtil.searchweather(cityname);
			Log.i("china", city.toString());
			bdutil = new DBUtil(context);
//			long size = bdutil.insert(city);
//			if (size > 0)
//			{
//				Toast.makeText(context, "写入数据库成功", 0).show();
//			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return city;
	}

	@Override
	protected void onPostExecute(CityWeather result)
	{
		turnback.back(result);
	}

	public interface turnBack
	{
		void back(CityWeather cw);
	}
}
