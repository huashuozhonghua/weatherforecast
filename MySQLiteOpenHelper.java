package com.weather.sqli;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper
{

	public MySQLiteOpenHelper(Context context)
	{
		super(context, "myweather.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		String sql = "create table " + MyData.TABLENAME + "  ("
				+ MyData.WEATHER.ID + " integer primary key autoincrement,"
				+ MyData.WEATHER.CITY + " varchar(28) not null unique,"
				+ MyData.WEATHER.CITYID + " varchar(22) not null unique,"
				+ MyData.WEATHER.LOCALDATE + " varchar(20) not null unique,"
				+ MyData.WEATHER.TODAYAQI + " varchar(12) not null ,"
				+ MyData.WEATHER.TODAYAQINAME + " varchar(20) not null ,"
				+ MyData.WEATHER.TODAYCONDD + " varchar(20) not null,"
				+ MyData.WEATHER.TODAYCONDN + " varchar(20) not null,"
				+ MyData.WEATHER.TODAYPM25 + " varchar(20) not null,"
				+ MyData.WEATHER.TODAYTMPMAX + " varchar(20) not null,"
				+ MyData.WEATHER.TODAYTMPMIN + " varchar(20) not null"
				+ MyData.WEATHER.NEXTDAYCOND + " varchar(20) not null"
				+ MyData.WEATHER.AFTERDAYCOND + " varchar(20) not null"

				+ " )";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{ // °æ±¾Éý¼¶

	}

}
