package com.weather.ui;

import java.util.ArrayList;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.weather.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

public class TuBiao extends Activity
{
	private LineChart mLineChart;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tubiao);
		// ����X��maxΪ36��Y��maxΪ100��
//		LineData mLineData = getLineData(1, 0);
//		showChart(mLineChart, mLineData, Color.rgb(114, 188, 223));
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
//			float value = (float) (Math.random() * range) + 3;
//			yValues.add(new Entry(range, i));
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
		// ����ƽ��
		lineDataSet.setDrawCubic(true);
		// ����ƽ����
		lineDataSet.setCubicIntensity(0.09f);
		// ���
		lineDataSet.setDrawFilled(true);
		// ����ɫ
		lineDataSet.setFillColor(Color.YELLOW);

		ArrayList<LineDataSet> lineDataSets = new ArrayList<LineDataSet>();
		lineDataSets.add(lineDataSet); // add the datasets

		// create a data object with the datasets
		LineData lineData = new LineData(xValues, lineDataSets);

		return lineData;
	}

}
