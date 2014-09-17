package com.supermap.imb.edit;

import com.supermap.imb.appconfig.MyApplication;
import com.supermap.mapping.MapControl;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;

public class SettingPopup extends PopupWindow implements OnClickListener{
	private MapControl mMapControl = null;
	private LayoutInflater mInflater = null;
	private View mContentView = null;
	
	/**
	 * 构造函数
	 * @param mapcontrol
	 */
	public SettingPopup(MapControl mapcontrol) {
		mMapControl = mapcontrol;
		mInflater = LayoutInflater.from(mMapControl.getContext());
		loadView();
		setContentView(mContentView);
		setWidth(LayoutParams.WRAP_CONTENT);
		setHeight(LayoutParams.WRAP_CONTENT);
		
		//设置默认
		mMapControl.setStrokeColor(mMapControl.getResources().getColor(R.color.red));
		mMapControl.setStrokeWidth(1);
	}
	
	/**
	 * 初始化界面
	 */
	private void loadView(){
		mContentView = mInflater.inflate(R.layout.settingbar, null);
		mContentView.findViewById(R.id.btn_size_1mm).setOnClickListener(this);
		mContentView.findViewById(R.id.btn_size_2mm).setOnClickListener(this);
		mContentView.findViewById(R.id.btn_size_3mm).setOnClickListener(this);
		mContentView.findViewById(R.id.btn_clolor_b).setOnClickListener(this);
		mContentView.findViewById(R.id.btn_clolor_g).setOnClickListener(this);
		mContentView.findViewById(R.id.btn_clolor_r).setOnClickListener(this);
	}
	
	/**
	 * 显示设置工具栏
	 */
	public void show(){
		showAtLocation(mMapControl.getRootView(), Gravity.LEFT|Gravity.TOP,MyApplication.dp2px(10), MyApplication.dp2px(80));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_size_1mm:
			mMapControl.setStrokeWidth(1);
			break;
		case R.id.btn_size_2mm:
			mMapControl.setStrokeWidth(2);
			break;
		case R.id.btn_size_3mm:
			mMapControl.setStrokeWidth(3);
			break;
		case R.id.btn_clolor_b:
			mMapControl.setStrokeColor(mMapControl.getResources().getColor(R.color.blue));
			break;
		case R.id.btn_clolor_g:
			mMapControl.setStrokeColor(mMapControl.getResources().getColor(R.color.green));
			break;
		case R.id.btn_clolor_r:
			mMapControl.setStrokeColor(mMapControl.getResources().getColor(R.color.red));
			break;

		default:
			break;
		}		
	}
}
