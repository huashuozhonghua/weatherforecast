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
		// ����X��maxΪ36��Y��maxΪ100��
		LineData mLineData = getLineData(36, 100);
		showChart(mLineChart, mLineData, Color.rgb(114, 188, 223));
	}

	private String transition(String name)
	{
		if (name.equals("����"))
		{
			return "chongqing";
		} else if (name.equals("�ɶ�"))
		{
			return "chengdu";
		} else if (name.equals("����"))
		{
			return "haikou";
		} else if (name.equals("���"))
		{
			return "tianjin";
		} else if (name.equals("�人"))
		{
			return "wuhan";
		} else if (name.equals("����"))
		{
			return "guangzhou";
		} else if (name.equals("�Ϻ�"))
		{
			return "shanghai";
		} else if (name.equals("����"))
		{
			return "beijing";
		} else if (name.equals("��ɳ"))
		{
			return "changsha";
		} else if (name.equals("�Ͼ�"))
		{
			return "nanjing";
		} else if (name.equals("����"))
		{
			return "kunming";
		} else if (name.equals("��³ľ��"))
		{
			return "wulumuqi";
		} else if (name.equals("����"))
		{
			return "shenzhen";
		} else if (name.equals("����"))
		{
			return "hangzhou";
		} else if (name.equals("����"))
		{
			return "shenyang";
		} else
			return null;
	}

	// ������ʾ����ʽ
	private void showChart(LineChart lineChart, LineData lineData, int color)
	{
		// �Ƿ�������ͼ����ӱ߿�
		lineChart.setDrawBorders(false);
		// ���û�����ݵ�ʱ�򣬻���ʾ���������listview��emtpyview
		lineChart.setDescription("");// ��������
		lineChart.setNoDataTextDescription("����Ҫ����Դ");
		// �Ƿ���ʾ�����ɫ
		lineChart.setDrawGridBackground(false);
		// ���ĵ���ɫ�����������Ǹ���ɫ����һ��͸����
		lineChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF);
		// �����Ƿ���Դ���
		lineChart.setTouchEnabled(true);
		// �Ƿ������ק
		lineChart.setDragEnabled(true);
		// �Ƿ��������
		lineChart.setScaleEnabled(true);
		// ����˫ָ����
		lineChart.setPinchZoom(false);
		// ���ñ���
		lineChart.setBackgroundColor(color);
		// �������ݣ����÷�����
		lineChart.setData(lineData);

		// �õ�legend (only possible after setting data)
		// ���ñ���ͼ��ʾ�������Ǹ�һ��y��value��
		Legend mLegend = lineChart.getLegend();
		// mLegend.setPosition(LegendPosition.LEFT_OF_CHART);
		// �޸�legend ...
		mLegend.setForm(LegendForm.CIRCLE);// ��ʽ
		mLegend.setFormSize(6f);// ����
		mLegend.setTextColor(Color.WHITE);// ��ɫ
		// mLegend.setTypeface(mTf);// �Զ�������

		lineChart.animateX(2500); // ����ִ�еĶ���,x��
	}

	/**
	 * ����һ������
	 * 
	 * @param count
	 *            ��ʾͼ�����ж��ٸ������
	 * @param range
	 *            ��������range���ڵ������
	 * @return
	 */
	private LineData getLineData(int count, float range)
	{
		ArrayList<String> xValues = new ArrayList<String>();
		for (int i = 0; i < count; i++)
		{
			// x����ʾ�����ݣ�����Ĭ��ʹ�������±���ʾ
			xValues.add("" + i);
		}

		// y�������
		ArrayList<Entry> yValues = new ArrayList<Entry>();
		for (int i = 0; i < count; i++)
		{
			float value = (float) (Math.random() * range) + 3;
			yValues.add(new Entry(value, i));
		}
		// create a dataset and give it a type
		// y������ݼ��� --------------------------------//��������ͼ/* ��ʾ�ڱ���ͼ�� */
		LineDataSet lineDataSet = new LineDataSet(yValues, "����Ԥ��ͼ");
		// mLineDataSet.setFillAlpha(110);
		// mLineDataSet.setFillColor(Color.RED);

		// ��y��ļ��������ò���
		// �߿�
		lineDataSet.setLineWidth(1.75f);
		// ��ʾ��Բ�δ�С
		lineDataSet.setCircleSize(3f);
		// ��ʾ��ɫ
		lineDataSet.setColor(Color.WHITE);
		// Բ�ε���ɫ
		lineDataSet.setCircleColor(Color.WHITE);
		// ʮ�ֹ����ߵ���ɫ
		lineDataSet.setHighLightColor(Color.RED);
		//����ƽ��
		lineDataSet.setDrawCubic(true);
		//����ƽ����
		lineDataSet.setCubicIntensity(0.09f);
		//���
		lineDataSet.setDrawFilled(true);
		//����ɫ
		lineDataSet.setFillColor(Color.YELLOW);

		ArrayList<LineDataSet> lineDataSets = new ArrayList<LineDataSet>();
		lineDataSets.add(lineDataSet); // add the datasets

		// create a data object with the datasets
		LineData lineData = new LineData(xValues, lineDataSets);

		return lineData;
	}

}
