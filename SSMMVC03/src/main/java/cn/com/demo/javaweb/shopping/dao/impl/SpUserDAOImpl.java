package cn.com.demo.javaweb.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.com.demo.javaweb.shopping.dao.ISpUserDAO;
import cn.com.demo.javaweb.shopping.db.DBConnection;
import cn.com.demo.javaweb.shopping.entity.SpProduct;
import cn.com.demo.javaweb.shopping.entity.SpUser;

public class SpUserDAOImpl implements ISpUserDAO {
	private DBConnection dbConn = DBConnection.getInstance();

	@Override
	public SpUser findByUserName(String userName) {
		SpUser pro = null;
		Connection conn = dbConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from sp_user where ur_user_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);

			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				pro = new SpUser();

				pro.setUrId(rs.getInt("ur_id"));
				pro.setUrPassword(rs.getString("ur_password"));
				pro.setUrUserName(rs.getString("ur_user_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return pro;
	}

}
