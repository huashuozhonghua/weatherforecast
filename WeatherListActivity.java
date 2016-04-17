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
		citynames = new String[] { "����", "�Ϻ�", "����", "�ɶ�", "��³ľ��", "�Ͼ�", "�人",
				"����", "����", "��ɳ", "���", "����", "����", "����", "����" };
	}


	/**
	 * ���ñ��̵Ĳ���ֵ
	 */
	// BiaoPanData data = new BiaoPanData();
	// data.setTianqi("��");
	// data.setCity("����");
	// data.setQiwen(9);
	// data.setZhiliang(random);
	// if(random>250){
	// data.setTishi("���������ܲ�,���ʺϻ����˶�");
	// data.setChengdu("����������");
	// }else{
	// data.setTishi("���Զ�μӻ���,��������");
	// data.setChengdu("��������");
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
