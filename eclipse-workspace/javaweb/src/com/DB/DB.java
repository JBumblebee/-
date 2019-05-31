package com.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.model.Good;
//代表数据库
//代表数据库
public class DB {
    
    private static Map<String, Good> map = new LinkedHashMap<String, Good>();
    
    public static Map<String, Good> getAll(){
    	Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?"
    				+ "useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false","root","root");
    		
    		String sql = "select * from good ";
    		//pstmt.setString(1, good.getType());
    		pstmt = connection.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {

    				Good good = new Good();
        			
    				good.setId(rs.getString("id"));
    				good.setName(rs.getString("name"));
    				good.setAuthor(rs.getString("author"));
    				good.setPrice(rs.getDouble("price"));
    				good.setDescription(rs.getString("description"));
    				good.setImg(rs.getString("img"));
        			map.put(rs.getString("id"), good);

    		}
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();	
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}catch(Exception e) {
			e.printStackTrace();
    	}finally{
			try {
				if(rs != null)  rs.close();
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
        return map;
    } 
    
}