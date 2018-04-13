package com.wifi.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**  
* 类说明   ：
*  
* @author qwk
* @date 2018年4月9日  新建  
*/
public class OneJson {
	private String id;
	private String mmac;
	private String time;
	private String lat;
	private String lon;
	private List<OneData> data;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMmac() {
		return mmac;
	}
	public void setMmac(String mmac) {
		this.mmac = mmac;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.ENGLISH);
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			time = format2.format(format.parse(time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.time = time;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public List<OneData> getData() {
		return data;
	}
	public void setData(List<OneData> data) {
		this.data = data;
	}
	
	
}
