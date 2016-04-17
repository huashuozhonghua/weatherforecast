package com.weather.entity;

import java.io.Serializable;

public class CityWeather
{
	private int id;
	private String date;
	private String name;
	private String cityid;
	private int codenumber;
	private String todaycondd;
	private String todaycondn;
	private String todaytmpmax;
	private String todaytmpmin;
	private String todaypm25;
	private int todayaqi;
	private String todayaqiname;
	private String nextdaycond;
	private String afterdaycond;

	
	public int getCodenumber()
	{
		return codenumber;
	}

	
	public String getTodayaqiname()
	{
		return todayaqiname;
	}

	public void setTodayaqiname(String todayaqiname)
	{
		this.todayaqiname = todayaqiname;
	}


	public void setCodenumber(int codenumber)
	{
		this.codenumber = codenumber;
	}

	public String getNextdaycond()
	{
		return nextdaycond;
	}

	public void setNextdaycond(String nextdaycond)
	{
		this.nextdaycond = nextdaycond;
	}

	public int getTodayaqi()
	{
		return todayaqi;
	}


	public void setTodayaqi(int todayaqi)
	{
		this.todayaqi = todayaqi;
	}


	public String getAfterdaycond()
	{
		return afterdaycond;
	}

	public void setAfterdaycond(String afterdaycond)
	{
		this.afterdaycond = afterdaycond;
	}

	public CityWeather()
	{
		super();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getCityid()
	{
		return cityid;
	}

	public void setCityid(String cityid)
	{
		this.cityid = cityid;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getTodaycondd()
	{
		return todaycondd;
	}

	public void setTodaycondd(String todaycondd)
	{
		this.todaycondd = todaycondd;
	}

	public String getTodaycondn()
	{
		return todaycondn;
	}

	public void setTodaycondn(String todaycondn)
	{
		this.todaycondn = todaycondn;
	}

	public String getTodaytmpmax()
	{
		return todaytmpmax;
	}

	public void setTodaytmpmax(String todaytmpmax)
	{
		this.todaytmpmax = todaytmpmax;
	}

	public String getTodaytmpmin()
	{
		return todaytmpmin;
	}

	public void setTodaytmpmin(String todaytmpmin)
	{
		this.todaytmpmin = todaytmpmin;
	}

	public String getTodaypm25()
	{
		return todaypm25;
	}

	public void setTodaypm25(String todaypm25)
	{
		this.todaypm25 = todaypm25;
	}



	public CityWeather(String name, String cityid, String date,
			String todaycondd, String todaycondn, String todaytmpmax,
			String todaytmpmin, String todaypm25, String todayaqiname)
	{
		super();
		this.name = name;
		this.cityid = cityid;
		this.date = date;
		this.todaycondd = todaycondd;
		this.todaycondn = todaycondn;
		this.todaytmpmax = todaytmpmax;
		this.todaytmpmin = todaytmpmin;
		this.todaypm25 = todaypm25;
		this.todayaqiname = todayaqiname;
	}

	@Override
	public String toString()
	{
		return "CityWeather [name=" + name + ", date=" + date + ", todaypm25="
				+ todaypm25 + ", todayaqi=" + todayaqi + "]";
	}

}
