package com.weather.ui;

import java.util.ArrayList;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.weather.R;
import com.weather.dal.WeatherBiz;
import com.weather.dal.WeatherBiz.turnBack;
import com.weather.entity.BiaoPanview;
import com.weather.entity.CityWeather;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class CityActivity extends Activity
{
	BiaoPanview biaopan;
	CityWeather mcity;
	private LineChart mLineChart;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.city_activity);
		biaopan = (BiaoPanview) findViewById(R.id.weather_biaopan);
		String name = getIntent().getStringExtra("china");
		mLineChart = (LineChart) findViewById(R.id.weather_linechart);
		new WeatherBiz(new turnBack()
		{
			@Override
			public void back(CityWeather cw)
			{
				mcity = cw;
				if (mcity != null)
				{
					biaopan.setBiaopanData(mcity);
				}
			}
		}, this).execute(transition(name));
		// 设置X轴max为36，Y轴max为100；
		LineData mLineData = getLineData(36, 100);
		showChart(mLineChart, mLineData, Color.rgb(114, 188, 223));
	}

	private String transition(String name)
	{
		if (name.equals("重庆"))
		{
			return "chongqing";
		} else if (name.equals("成都"))
		{
			return "chengdu";
		} else if (name.equals("海口"))
		{
			return "haikou";
		} else if (name.equals("天津"))
		{
			return "tianjin";
		} else if (name.equals("武汉"))
		{
			return "wuhan";
		} else if (name.equals("广州"))
		{
			return "guangzhou";
		} else if (name.equals("上海"))
		{
			return "shanghai";
		} else if (name.equals("北京"))
		{
			return "beijing";
		} else if (name.equals("长沙"))
		{
			return "changsha";
		} else if (name.equals("南京"))
		{
			return "nanjing";
		} else if (name.equals("昆明"))
		{
			return "kunming";
		} else if (name.equals("乌鲁木齐"))
		{
			return "wulumuqi";
		} else if (name.equals("深圳"))
		{
			return "shenzhen";
		} else if (name.equals("杭州"))
		{
			return "hangzhou";
		} else if (name.equals("沈阳"))
		{
			return "shenyang";
		} else
			return null;
	}

	// 设置显示的样式
	private void showChart(LineChart lineChart, LineData lineData, int color)
	{
		// 是否在折线图上添加边框
		lineChart.setDrawBorders(false);
		// 如果没有数据的时候，会显示这个，类似listview的emtpyview
		lineChart.setDescription("");// 数据描述
		lineChart.setNoDataTextDescription("你需要数据源");
		// 是否显示表格颜色
		lineChart.setDrawGridBackground(false);
		// 表格的的颜色，在这里是是给颜色设置一个透明度
		lineChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF);
		// 设置是否可以触摸
		lineChart.setTouchEnabled(true);
		// 是否可以拖拽
		lineChart.setDragEnabled(true);
		// 是否可以缩放
		lineChart.setScaleEnabled(true);
		// 设置双指缩放
		lineChart.setPinchZoom(false);
		// 设置背景
		lineChart.setBackgroundColor(color);
		// 设置数据（调用方法）
		lineChart.setData(lineData);

		// 得到legend (only possible after setting data)
		// 设置比例图标示，就是那个一组y的value的
		Legend mLegend = lineChart.getLegend();
		// mLegend.setPosition(LegendPosition.LEFT_OF_CHART);
		// 修改legend ...
		mLegend.setForm(LegendForm.CIRCLE);// 样式
		mLegend.setFormSize(6f);// 字体
		mLegend.setTextColor(Color.WHITE);// 颜色
		// mLegend.setTypeface(mTf);// 自定义字体

		lineChart.animateX(2500); // 立即执行的动画,x轴
	}

	/**
	 * 生成一个数据
	 * 
	 * @param count
	 *            表示图表中有多少个坐标点
	 * @param range
	 *            用来生成range以内的随机数
	 * @return
	 */
	private LineData getLineData(int count, float range)
	{
		ArrayList<String> xValues = new ArrayList<String>();
		for (int i = 0; i < count; i++)
		{
			// x轴显示的数据，这里默认使用数字下标显示
			xValues.add("" + i);
		}

		// y轴的数据
		ArrayList<Entry> yValues = new ArrayList<Entry>();
		for (int i = 0; i < count; i++)
		{
			float value = (float) (Math.random() * range) + 3;
			yValues.add(new Entry(value, i));
		}
		// create a dataset and give it a type
		// y轴的数据集合 --------------------------------//测试折线图/* 显示在比例图上 */
		LineDataSet lineDataSet = new LineDataSet(yValues, "天气预报图");
		// mLineDataSet.setFillAlpha(110);
		// mLineDataSet.setFillColor(Color.RED);

		// 用y轴的集合来设置参数
		// 线宽
		lineDataSet.setLineWidth(1.75f);
		// 显示的圆形大小
		lineDataSet.setCircleSize(3f);
		// 显示颜色
		lineDataSet.setColor(Color.WHITE);
		// 圆形的颜色
		lineDataSet.setCircleColor(Color.WHITE);
		// 十字光标的线的颜色
		lineDataSet.setHighLightColor(Color.RED);
		//设置平滑
		lineDataSet.setDrawCubic(true);
		//设置平滑度
		lineDataSet.setCubicIntensity(0.09f);
		//填充
		lineDataSet.setDrawFilled(true);
		//填充顏色
		lineDataSet.setFillColor(Color.YELLOW);

		ArrayList<LineDataSet> lineDataSets = new ArrayList<LineDataSet>();
		lineDataSets.add(lineDataSet); // add the datasets

		// create a data object with the datasets
		LineData lineData = new LineData(xValues, lineDataSets);

		return lineData;
	}

}
