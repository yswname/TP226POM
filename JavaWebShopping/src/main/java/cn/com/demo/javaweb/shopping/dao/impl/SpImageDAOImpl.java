package cn.com.demo.javaweb.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.com.demo.javaweb.shopping.dao.ISpImageDAO;
import cn.com.demo.javaweb.shopping.db.DBConnection;
import cn.com.demo.javaweb.shopping.entity.SpImage;
import cn.com.demo.javaweb.shopping.entity.SpProduct;

public class SpImageDAOImpl implements ISpImageDAO {
	private DBConnection dbConn = DBConnection.getInstance();

	@Override
	public List<SpImage> findImages(int type, int prId) {
		List<SpImage> list = null;

		Connection conn = dbConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from sp_images where img_type=? and img_pr_id=? order by img_id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			pstmt.setInt(2, prId);
			
			rs = pstmt.executeQuery();
			if(rs != null) {
				list = new ArrayList<SpImage>();
				SpImage image = null;
				while(rs.next()) {
					image = new SpImage();
					list.add(image);
					
					image.setImgId(rs.getInt("img_id"));
					image.setImgPrId(rs.getInt("img_pr_id"));
					image.setImgTitle(rs.getString("img_title"));
					image.setImgType(rs.getInt("img_type"));
					image.setImgUrl(rs.getString("img_url"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.close(conn, pstmt, rs);
		}

		return list;
	}

}
