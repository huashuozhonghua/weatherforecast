package com.weather.sqli;

public class MyData
{
	public static String TABLENAME = "city_weather";

	public static class WEATHER
	{

		public static String ID = "_id";
		public static String CITY = "city_name";
		public static String CITYID = "city_id";
		public static String LOCALDATE = "local_date";// 时间
		public static String TODAYCONDD = "today_cond_d";// 天气白天
		public static String TODAYCONDN = "today_cond_n";// 天气晚上
		public static String TODAYTMPMAX = "today_tmp_max";// 温度最高
		public static String TODAYTMPMIN = "today_tmp_min";// 温度最低
		public static String TODAYPM25 = "today_pm25";// pm2.5
		public static String TODAYAQI = "today_aqi";// 空气质量指数
		public static String TODAYAQINAME = "today_aqi_name";// 空气质量指数
		public static String NEXTDAYCOND = "nextday_cond";
		public static String AFTERDAYCOND = "afterday_cond";
	}
}
