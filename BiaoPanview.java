package com.weather.entity;

import com.weather.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

/*
 * 内圆122
 * 外圆204
 * 圆环22
 */
public class BiaoPanview extends View
{
	private int measuredHeight;
	private int measuredWidth;
	private WindowManager wm;
	private int width;
	private int height;
	private Pointer circlePointer;
	private CityWeather cityweather;
	private float innerCircleRadius; // 内圆半径
	private float outsideCircleRadius; // 外圆半径
	private float yuanhuanRadius; // 圆环半径

	public BiaoPanview(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	@SuppressLint("DrawAllocation")
	@SuppressWarnings("deprecation")
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		wm = (WindowManager) getContext().getSystemService(
				Context.WINDOW_SERVICE);
		width = wm.getDefaultDisplay().getWidth();
		height = wm.getDefaultDisplay().getHeight();
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		params.setMargins(width * 33 / 320, 0, 0, 0); // 设置控件的margin
		setLayoutParams(params);
		setMeasuredDimension(width * 254 / 320, width * 254 / 320); // 设置控件的尺寸
		measuredHeight = getMeasuredHeight(); // 测量控件高度
		measuredWidth = getMeasuredWidth(); // 测量控件宽度
		getCirclePointer(); // 获取圆心坐标
		innerCircleRadius = 248 * measuredWidth / 512 / 2;
		outsideCircleRadius = 410 * measuredWidth / 512 / 2;
		yuanhuanRadius = 46 * measuredWidth / 512 / 2;
	}

	/**
	 * 获取圆心坐标
	 */
	private void getCirclePointer()
	{
		float x = width / 2 - (width - measuredWidth) / 2;
		float y = (getY() + measuredHeight) / 2;
		circlePointer = new Pointer(x, y);
		System.out.println(circlePointer);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setAntiAlias(true);

		// 设置天气数据
		if (cityweather != null)
		{ // 数据不为空绘制数据
			paint.setTextSize(dip2px(getContext(), 36));
			paint.setTextAlign(Align.CENTER);
			// 空气质量指数
			canvas.drawText(cityweather.getTodayaqi() + "",
					circlePointer.getX(),
					circlePointer.getY() - dip2px(getContext(), 6), paint);
			paint.setTextSize(dip2px(getContext(), 18));
			// 空气质量（良，差）
			canvas.drawText(cityweather.getTodayaqiname(),
					circlePointer.getX(),
					circlePointer.getY() + dip2px(getContext(), 15), paint);
			// 天气（晴，雨）
			paint.setTextSize(dip2px(getContext(), 14));
			canvas.drawText(
					cityweather.getTodaycondd() + "  "
							+ cityweather.getTodaytmpmax() + "°C",
					circlePointer.getX(),
					circlePointer.getY() + dip2px(getContext(), 28), paint);
			paint.setColor(Color.WHITE);
			// 城市名称
			paint.setTextSize(dip2px(getContext(), 30));
			canvas.drawText(cityweather.getName(), circlePointer.getX(),
					circlePointer.getY() + outsideCircleRadius - yuanhuanRadius
							/ 2, paint);

			// 画质量的圆圈,根据 质量指数设置质量指数圆圈位置
			double scale = (double) Double.valueOf(cityweather.getTodaypm25()) / 500d;
			Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
					R.drawable.icon_biaopan_x);
			Pointer pointer = getZhiLiangCirclePointer(scale, bitmap);
			float left = pointer.getX();
			float top = pointer.getY();
			paint = new Paint();
			canvas.drawBitmap(bitmap, left, top, paint);
		}
	}

	/**
	 * 根据数据获取质量的圆圈的圆心坐标
	 * 
	 * @param scale
	 */
	private Pointer getZhiLiangCirclePointer(double scale, Bitmap bitmap)
	{
		double angle = (45 + (845 - 45) * scale) * Math.PI / 180;
		float radius = outsideCircleRadius - yuanhuanRadius
				- dip2px(getContext(), 1.5f); // 半径

		float pointerX = circlePointer.getX() - bitmap.getWidth() / 2;
		float pointerY = circlePointer.getY() - bitmap.getHeight() / 2 + radius;

		float dX = radius * (float) Math.sin(angle);
		float dY = (float) (radius * Math.cos(angle));
		float x = pointerX - dX;
		float y = pointerY - (radius - dY);
		return new Pointer(x, y);
	}

	/**
	 * 根据手机的分辨率?dp 转成?px(像素)
	 */
	public static int dip2px(Context context, float dpValue)
	{
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率�?px(像素) 的单�?转成�?dp
	 */
	public static int px2dip(Context context, float pxValue)
	{
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 设置数据
	 * 
	 * @param data
	 */
	public void setBiaopanData(CityWeather city)
	{
		this.cityweather = city;
		invalidate();
	}

}
