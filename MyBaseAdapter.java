package com.weather.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class MyBaseAdapter<T> extends android.widget.BaseAdapter
{
	private Context context;
	/**
	 * ����Դ
	 */
	private List<T> data;
	/**
	 * ��ģ�����Ϊ���ֶ���Ĺ���
	 */
	private LayoutInflater layoutInflater;

	/**
	 * ���췽��
	 * 
	 * @param context
	 *            �����Ķ��󣬲�����Ϊnull
	 * @param data
	 *            ����Դ
	 */
	public MyBaseAdapter(Context context, List<T> data)
	{
		super();
		setContext(context);
		setData(data);
		setLayoutInflater();
	}

	/**
	 * ��ȡContext����
	 * 
	 * @return Context����
	 */
	public Context getContext()
	{
		return context;
	}

	/**
	 * ����Context����
	 * 
	 * @param context
	 *            Context���󣬲�����Ϊnull
	 */
	public void setContext(Context context)
	{
		if (context == null)
		{
			throw new IllegalArgumentException("����Context������Ϊnull������");
		}
		this.context = context;
	}

	/**
	 * ��ȡ����Դ
	 * 
	 * @return ����Դ
	 */
	public List<T> getData()
	{
		return data;
	}

	/**
	 * ��������Դ
	 * 
	 * @param data
	 *            ����Դ
	 */
	public void setData(List<T> data)
	{
		if (data == null)
		{
			data = new ArrayList<T>();
		}
		this.data = data;
	}

	/**
	 * ��ȡLayoutInflater����
	 * 
	 * @return LayoutInflater����
	 */
	public LayoutInflater getLayoutInflater()
	{
		return layoutInflater;
	}

	/**
	 * ����LayoutInflater
	 */
	private void setLayoutInflater()
	{
		this.layoutInflater = LayoutInflater.from(this.context);
	}

	@Override
	public int getCount()
	{
		return data.size();
	}

	@Override
	public Object getItem(int position)
	{
		return null;
	}

	@Override
	public long getItemId(int position)
	{
		return 0;
	}

}
