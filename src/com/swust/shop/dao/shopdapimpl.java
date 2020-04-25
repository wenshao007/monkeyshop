package com.swust.shop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;
import java.sql.Date;
import java.sql.PreparedStatement;
import com.swust.shop.Beans.User;

public class shopdapimpl implements Ishopdao {

	//插入用户信息
	public boolean insertuer(User u) {
		Connection conn = null;
		PreparedStatement ps = null;
		Date date = new Date(new java.util.Date().getTime());
		
		
		 try {
			 String sql = "insert into lmonkey_user(USER_NAME,USER_PASSWORD,USER_SEX,USER_BIRTHDAY,USER_EMAIL,USER_MOBILE,USER_ADDRESS,USER_STATUS,USER_ID)values(?,?,?,?,?,?,?,?,?)";
			conn = DButil.getconnection();
	
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUSER_NAME());
			ps.setString(2, u.getUSER_PASSWORD());
			ps.setString(3, u.getUSER_SEX());
			ps.setDate(4,date);
			ps.setString(5, u.getUSER_EMAIL());
			ps.setString(6, u.getUSER_MOBILE());
			ps.setString(7, u.getUSER_ADDRESS());
			ps.setString(8, u.getUSER_STATUS());
			ps.setString(9, "cz");
			
			int i = ps.executeUpdate();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
		
	}

		//查询用户信息,并放入一个list集合
	@Override
	public List queryUser(int count,int cpage,String keyword) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<User> list  = new ArrayList<User>() ;
		
		//当有关键字搜索时
		if(keyword!=null&&keyword!="") {
			try {
				String sql = "select * from lmonkey_user where USER_NAME like ? limit ?,?;";
				conn = DButil.getconnection();
				System.out.println("连接连接");
				ps = conn.prepareStatement(sql);
				ps.setString(1, keyword);
				ps.setInt(2, count*(cpage-1));
				ps.setInt(3, count);
				rs = ps.executeQuery();  //获取到查询结果集
				while(rs.next()) {
					User user = new User(rs.getString("USER_ID"),
														rs.getString("USER_NAME"), 
														rs.getString("USER_PASSWORD"), 
														rs.getString("USER_SEX"), 
														format.format(rs.getDate("USER_BIRTHDAY")), 
														null, 
														rs.getString("USER_EMAIL"), 
														rs.getString("USER_MOBILE"), 	
														rs.getString("USER_ADDRESS"), 
														rs.getString("USER_STATUS"));
					list.add(user);
				}
				return list;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		//无关键字全局搜索时
		//limit后面跟的两个数字x,y		含义是查询出从第x条记录开始往后的y条记录
		String sql = "select * from lmonkey_user limit ?,?;";
		try {
			conn = DButil.getconnection();
			System.out.println("连接连接");
			ps = conn.prepareStatement(sql);
			ps.setInt(1, count*(cpage-1));
			ps.setInt(2, count);
			rs = ps.executeQuery();  //获取到查询结果集
			while(rs.next()) {
				User user = new User(rs.getString("USER_ID"),
													rs.getString("USER_NAME"), 
													rs.getString("USER_PASSWORD"), 
													rs.getString("USER_SEX"), 
													format.format(rs.getDate("USER_BIRTHDAY")), 
													null, 
													rs.getString("USER_EMAIL"), 
													rs.getString("USER_MOBILE"), 	
													rs.getString("USER_ADDRESS"), 
													rs.getString("USER_STATUS"));
				list.add(user);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
	}

	
	//对于不同的关键字，获取分页的页数，以及总条数,count是每页的条数
	@Override
	public int[] listPage(int count,String keyword) {
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int i =0 ;
		int[] arr = {0,1}; //arr[0]定位总条数，arr[1]定位总页数
		
		if(keyword!="" && keyword!=null) {
			String sql = "select count(*) from lmonkey_user where USER_NAME like ?";
			try {
				conn = DButil.getconnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, keyword);
				rs = ps.executeQuery();
				while(rs.next()) {
					i =  rs.getInt(1);
					System.out.println(i);
				}
				if(i%count==0) {
					arr[1] = i/count;
				}else {
					arr[1] = i/count+1;
				}
				arr[0] = i;
				return arr;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					ps.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		else 
		{
			String sql = "select count(*) from lmonkey_user";
			try {
				
				conn = DButil.getconnection();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					i =  rs.getInt(1);
				}
				if(i%count==0) {
					arr[1] = i/count;
				}else {
					arr[1] = i/count+1;
				}
				arr[0] = i;
				return arr;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					ps.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
