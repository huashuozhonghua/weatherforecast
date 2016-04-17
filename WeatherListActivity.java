package com.weather.ui;

import com.weather.R;
import com.weather.dal.WeatherBiz;
import com.weather.dal.WeatherBiz.turnBack;
import com.weather.entity.BiaoPanview;
import com.weather.entity.CityWeather;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class WeatherListActivity extends Activity implements
		OnItemClickListener
{
	ListView citylist;
	CityWeather mcity;
	ArrayAdapter<String> adapter;
	String[] citynames;
	BiaoPanview biaopan;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weatherlist);
		initView();
		setAdapter();
		citylist.setOnItemClickListener(this);
	}

	private void setAdapter()
	{
		setcityname();
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, citynames);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		citylist.setAdapter(adapter);
	}

	private void initView()
	{
		citylist = (ListView) findViewById(R.id.lv_citys);
	}

	public void setcityname()
	{
		citynames = new String[] { "北京", "上海", "重庆", "成都", "乌鲁木齐", "南京", "武汉",
				"广州", "海口", "长沙", "天津", "深圳", "杭州", "昆明", "沈阳" };
	}


	/**
	 * 设置表盘的参数值
	 */
	// BiaoPanData data = new BiaoPanData();
	// data.setTianqi("晴");
	// data.setCity("北京");
	// data.setQiwen(9);
	// data.setZhiliang(random);
	// if(random>250){
	// data.setTishi("空气质量很差,不适合户外运动");
	// data.setChengdu("空气质量差");
	// }else{
	// data.setTishi("可以多参加户外活动,呼吸空气");
	// data.setChengdu("空气正常");
	// }

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id)
	{
		String name = citynames[position];
		Log.i("china", name);
		Intent intent = new Intent(this, CityActivity.class);
		intent.putExtra("china", name);
		startActivity(intent);
	}

}
