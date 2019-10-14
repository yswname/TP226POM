package cn.com.demo.tp05.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.com.demo.tp05.db.DBConnection;
import cn.com.demo.tp05.entity.UserEntity;

/**
 * 用户得持久层代码
 * */
public class UserDAO {
	private DBConnection dbConn = DBConnection.getInstance();

     public void addUser(UserEntity user) {
    	 Connection conn = dbConn.getConnection();
    	 PreparedStatement stmt = null;
    	 ResultSet rs = null;
    	 try {
    		 String sql = "insert into yy_user(ur_user_name,ur_password,ur_sex,ur_age,ur_phone) values(?,?,?,?,?)";
    		 stmt = conn.prepareStatement(sql);
    		 stmt.setString(1, user.getUrUserName());
    		 stmt.setString(2, user.getUrPassword());
    		 stmt.setString(3, user.getUrSex());
    		 stmt.setInt(4, user.getUrAge());
    		 stmt.setString(5, user.getUrPhone());
    		 
    		 stmt.executeUpdate();
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }finally {
    		 dbConn.close(conn, stmt, rs);
    	 }
     }
     
     public void updateUser(UserEntity user) {
    	 Connection conn = dbConn.getConnection();
    	 PreparedStatement stmt = null;
    	 ResultSet rs = null;
    	 try {
    		 String sql = "update yy_user set ur_password=?,ur_age=?,ur_phone=?,ur_sex=? where ur_id=?";
    		 stmt = conn.prepareStatement(sql);
    		 stmt.setInt(5, user.getUrId());
    		 stmt.setString(1, user.getUrPassword());
    		 stmt.setString(4, user.getUrSex());
    		 stmt.setInt(2, user.getUrAge());
    		 stmt.setString(3, user.getUrPhone());
    		 
    		 stmt.executeUpdate();
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }finally {
    		 dbConn.close(conn, stmt, rs);
    	 }
     }
     public UserEntity findByUserName(String userName) {
    	 UserEntity user = null;
    	 Connection conn = dbConn.getConnection();
    	 PreparedStatement stmt = null;
    	 ResultSet rs = null;
    	 try {
    		 String sql = "select * from yy_user where ur_user_name=?";
    		 stmt = conn.prepareStatement(sql);
    		 stmt.setString(1, userName);
    		 
    		 rs = stmt.executeQuery();
    		 if(rs.next()) {
    			 user = new UserEntity();
    			 user.setUrAge(rs.getInt("ur_age"));
    			 user.setUrId(rs.getInt("ur_id"));
    			 user.setUrPassword(rs.getString("ur_password"));
    			 user.setUrPhone(rs.getString("ur_phone"));
    			 user.setUrSex(rs.getString("ur_sex"));
    			 user.setUrUserName(rs.getString("ur_user_name"));
    		 }
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }finally {
    		 dbConn.close(conn, stmt, rs);
    	 }
    	 return user;
     }
     
     public UserEntity findById(int urId) {
    	 UserEntity user = null;
    	 Connection conn = dbConn.getConnection();
    	 PreparedStatement stmt = null;
    	 ResultSet rs = null;
    	 try {
    		 String sql = "select * from yy_user where ur_id=?";
    		 stmt = conn.prepareStatement(sql);
    		 stmt.setInt(1, urId);
    		 
    		 rs = stmt.executeQuery();
    		 if(rs.next()) {
    			 user = new UserEntity();
    			 user.setUrAge(rs.getInt("ur_age"));
    			 user.setUrId(rs.getInt("ur_id"));
    			 user.setUrPassword(rs.getString("ur_password"));
    			 user.setUrPhone(rs.getString("ur_phone"));
    			 user.setUrSex(rs.getString("ur_sex"));
    			 user.setUrUserName(rs.getString("ur_user_name"));
    		 }
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }finally {
    		 dbConn.close(conn, stmt, rs);
    	 }
    	 return user;
     }
     public List<UserEntity> findAll(){
    	 List<UserEntity> userList = null;
    	 Connection conn = dbConn.getConnection();
    	 PreparedStatement stmt = null;
    	 ResultSet rs = null;
    	 try {
    		 String sql = "select * from yy_user order by ur_id";
    		 stmt = conn.prepareStatement(sql);
    		 
    		 rs = stmt.executeQuery();
    		 UserEntity user = null;
    		 userList = new ArrayList<UserEntity>();
    		 while(rs.next()) {
    			 user = new UserEntity();
    			 user.setUrAge(rs.getInt("ur_age"));
    			 user.setUrId(rs.getInt("ur_id"));
    			 user.setUrPassword(rs.getString("ur_password"));
    			 user.setUrPhone(rs.getString("ur_phone"));
    			 user.setUrSex(rs.getString("ur_sex"));
    			 user.setUrUserName(rs.getString("ur_user_name"));
    			 
    			 userList.add(user);
    		 }
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }finally {
    		 dbConn.close(conn, stmt, rs);
    	 }
    	 return userList;
     }
}
