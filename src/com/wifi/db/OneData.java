package com.wifi.db;
/**  
* 类说明   ：
*  
* @author qwk 
* @date 2018年4月9日  新建  
*/
public class OneData {
	private String mac;
	private int rssi;
	private String ch;
	private int range;
	private String tmc;
	private String ts;
	private String tc;
	private String ds;
	
	public String getTmc() {
		return tmc;
	}
	public void setTmc(String tmc) {
		this.tmc = tmc;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getDs() {
		return ds;
	}
	public void setDs(String ds) {
		this.ds = ds;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public int getRssi() {
		return rssi;
	}
	public void setRssi(int rssi) {
		this.rssi = rssi;
	}
	public String getCh() {
		return ch;
	}
	public void setCh(String ch) {
		this.ch = ch;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	
	
}
