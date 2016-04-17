package com.weather.util;

import java.util.ArrayList;
import java.util.List;

import com.weather.entity.CityWeather;
import com.weather.sqli.MyData;
import com.weather.sqli.MySQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBUtil
{
	private Context context;

	public DBUtil(Context context)
	{
		this.context = context;
	}

	public int update(CityWeather cityweather)
	{
		MySQLiteOpenHelper openhelper = new MySQLiteOpenHelper(context);
		SQLiteDatabase db = openhelper.getWritableDatabase();
		String table = MyData.TABLENAME;
		ContentValues values = new ContentValues();
		values.put(MyData.WEATHER.LOCALDATE, cityweather.getDate());
		values.put(MyData.WEATHER.LOCALDATE, cityweather.getCityid());
		values.put(MyData.WEATHER.TODAYAQINAME, cityweather.getTodayaqi());
		values.put(MyData.WEATHER.TODAYCONDD, cityweather.getTodaycondd());
		values.put(MyData.WEATHER.TODAYCONDN, cityweather.getTodaycondn());
		values.put(MyData.WEATHER.TODAYPM25, cityweather.getTodaypm25());
		values.put(MyData.WEATHER.TODAYTMPMAX, cityweather.getTodaytmpmax());
		values.put(MyData.WEATHER.TODAYTMPMIN, cityweather.getTodaytmpmin());
		String whereClause = MyData.WEATHER.ID + "=?";
		String[] whereArgs = { cityweather.getId() + "" };
		int a = db.update(table, values, whereClause, whereArgs);
		return a;
	}

	public long insert(CityWeather citywe)
	{
		MySQLiteOpenHelper openhelper = new MySQLiteOpenHelper(context);
		SQLiteDatabase db = openhelper.getWritableDatabase();
		String table = MyData.TABLENAME;
		ContentValues values = new ContentValues();
		values.put(MyData.WEATHER.ID, citywe.getId());
		values.put(MyData.WEATHER.CITY, citywe.getName());
		values.put(MyData.WEATHER.CITYID, citywe.getCityid());
		values.put(MyData.WEATHER.LOCALDATE, citywe.getDate());
		values.put(MyData.WEATHER.TODAYAQI, citywe.getTodayaqi());
		values.put(MyData.WEATHER.TODAYCONDD, citywe.getTodaycondd());
		values.put(MyData.WEATHER.TODAYCONDN, citywe.getTodaycondn());
		values.put(MyData.WEATHER.TODAYPM25, citywe.getTodaypm25());
		values.put(MyData.WEATHER.TODAYTMPMAX, citywe.getTodaytmpmax());
		values.put(MyData.WEATHER.TODAYTMPMIN, citywe.getTodaytmpmin());
		long b = db.insert(table, MyData.WEATHER.ID, values);
		return b;
	}

	public Cursor getCursor()
	{
		MySQLiteOpenHelper openhelper = new MySQLiteOpenHelper(context);
		SQLiteDatabase db = openhelper.getWritableDatabase();
		Cursor c = db.query(MyData.TABLENAME, null, null, null, null, null,
				null);
		return c;
	}

	public List<CityWeather> getcitys(String whereClause, String[] whereArgs)
	{
		List<CityWeather> citys = new ArrayList<CityWeather>();
		MySQLiteOpenHelper openhelper = new MySQLiteOpenHelper(context);
		SQLiteDatabase db = openhelper.getWritableDatabase();
		Cursor c = db.query(MyData.TABLENAME, null, whereClause, whereArgs,
				null, null, null);
		while (c.moveToNext())
		{
			String name = c.getString(c.getColumnIndex(MyData.WEATHER.CITY));
			String cityid = c
					.getString(c.getColumnIndex(MyData.WEATHER.CITYID));
			String date = c.getString(c
					.getColumnIndex(MyData.WEATHER.LOCALDATE));
			String aqiname = c.getString(c.getColumnIndex(MyData.WEATHER.TODAYAQINAME));
			String condd = c.getString(c
					.getColumnIndex(MyData.WEATHER.TODAYCONDD));
			String condn = c.getString(c
					.getColumnIndex(MyData.WEATHER.TODAYCONDN));
			String pm25 = c.getString(c
					.getColumnIndex(MyData.WEATHER.TODAYPM25));
			String tmpmax = c.getString(c
					.getColumnIndex(MyData.WEATHER.TODAYTMPMAX));
			String tmpmin = c.getString(c
					.getColumnIndex(MyData.WEATHER.TODAYTMPMIN));
			CityWeather city = new CityWeather(name, cityid, date, condd,
					condn, tmpmax, tmpmin, pm25, aqiname);
			citys.add(city);
		}
		return citys;

	}
}
