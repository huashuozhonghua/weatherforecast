package com.weather.sqli;

public class MyData
{
	public static String TABLENAME = "city_weather";

	public static class WEATHER
	{

		public static String ID = "_id";
		public static String CITY = "city_name";
		public static String CITYID = "city_id";
		public static String LOCALDATE = "local_date";// ʱ��
		public static String TODAYCONDD = "today_cond_d";// ��������
		public static String TODAYCONDN = "today_cond_n";// ��������
		public static String TODAYTMPMAX = "today_tmp_max";// �¶����
		public static String TODAYTMPMIN = "today_tmp_min";// �¶����
		public static String TODAYPM25 = "today_pm25";// pm2.5
		public static String TODAYAQI = "today_aqi";// ��������ָ��
		public static String TODAYAQINAME = "today_aqi_name";// ��������ָ��
		public static String NEXTDAYCOND = "nextday_cond";
		public static String AFTERDAYCOND = "afterday_cond";
	}
}
