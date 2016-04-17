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
	 * 数据源
	 */
	private List<T> data;
	/**
	 * 将模板加载为布局对象的工具
	 */
	private LayoutInflater layoutInflater;

	/**
	 * 构造方法
	 * 
	 * @param context
	 *            上下文对象，不允许为null
	 * @param data
	 *            数据源
	 */
	public MyBaseAdapter(Context context, List<T> data)
	{
		super();
		setContext(context);
		setData(data);
		setLayoutInflater();
	}

	/**
	 * 获取Context对象
	 * 
	 * @return Context对象
	 */
	public Context getContext()
	{
		return context;
	}

	/**
	 * 设置Context对象
	 * 
	 * @param context
	 *            Context对象，不允许为null
	 */
	public void setContext(Context context)
	{
		if (context == null)
		{
			throw new IllegalArgumentException("参数Context不允许为null！！！");
		}
		this.context = context;
	}

	/**
	 * 获取数据源
	 * 
	 * @return 数据源
	 */
	public List<T> getData()
	{
		return data;
	}

	/**
	 * 设置数据源
	 * 
	 * @param data
	 *            数据源
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
	 * 获取LayoutInflater对象
	 * 
	 * @return LayoutInflater对象
	 */
	public LayoutInflater getLayoutInflater()
	{
		return layoutInflater;
	}

	/**
	 * 设置LayoutInflater
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
