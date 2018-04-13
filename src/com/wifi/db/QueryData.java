package com.wifi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 类说明 ：
 * 
 * @author ****
 * @date 2018年4月9日 新建
 */
public class QueryData {

	// 查询最新客流量
	public static int query_guestNum() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int guestNum = 0;
		try {
			conn = DbUtils.getConnection();
			// 3.操作数据库
			String sql = "SELECT count(*) as num FROM wifiData GROUP BY time order by time desc limit 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				guestNum = rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResultSet(rs);
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);

		}

		return guestNum;
	}

	// 查询最新入店量
	public static int query_entryNum() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int guestNum = 0;
		try {
			conn = DbUtils.getConnection();
			// 3.操作数据库
			String sql = "SELECT count(*) as num FROM wifiData where rangedis<300 GROUP BY time order by time desc limit 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				guestNum = rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResultSet(rs);
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);

		}

		return guestNum;
	}

	
	// 查询客流量趋势（最新的时间分组10条）
		public static Map<String,Integer> query_guestFlow() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Map<String,Integer> datamap = new TreeMap<String,Integer>();
			try {
				conn = DbUtils.getConnection();
				// 3.操作数据库
				String sql = "select * from (SELECT time,count(*) as num FROM wifiData GROUP BY time order by time desc limit 10) t order by time";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					datamap.put(rs.getString("time"), rs.getInt("num"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DbUtils.closeResultSet(rs);
				DbUtils.closePreparedStatement(pstmt);
				DbUtils.closeConnection(conn);

			}

			return datamap;
		}
	
	// 查询入店量趋势（最新的时间分组10条）
	public static Map<String,Integer> query_entryFlow() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String,Integer> datamap = new TreeMap<String,Integer>();
		try {
			conn = DbUtils.getConnection();
			// 3.操作数据库
			String sql = "select * from (SELECT time,count(*) as num FROM wifiData where rangedis<300 GROUP BY time order by time desc limit 10) t order by time";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				datamap.put(rs.getString("time"), rs.getInt("num"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeResultSet(rs);
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);

		}

		return datamap;
	}

}
