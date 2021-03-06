package cn.com.demo.javaweb.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.com.demo.javaweb.shopping.dao.ISpProductDAO;
import cn.com.demo.javaweb.shopping.db.DBConnection;
import cn.com.demo.javaweb.shopping.entity.SpProduct;

public class SpProductDAOImpl implements ISpProductDAO {
	private DBConnection dbConn = DBConnection.getInstance();

	@Override
	public SpProduct findById(int prId) {
		SpProduct pro = null;

		Connection conn = dbConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from sp_product where pr_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prId);

			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				pro = new SpProduct();
				pro.setPrTitle(rs.getString("pr_title"));
				pro.setPrCtId(rs.getInt("pr_ct_id"));
				pro.setPrDetailDesc(rs.getString("pr_detail_desc"));
				pro.setPrId(rs.getInt("pr_id"));
				pro.setPrPrice(rs.getDouble("pr_price"));
				pro.setPrSimpleDesc(rs.getString("pr_simple_desc"));
				pro.setPrAttrs(rs.getString("pr_attrs"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.close(conn, pstmt, rs);
		}

		return pro;
	}

	@Override
	public List<SpProduct> findByCondition(String whereSql, List params) {
		List<SpProduct> list = null;

		Connection conn = dbConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from sp_product " + whereSql;
			pstmt = conn.prepareStatement(sql);
			if (params != null && params.size() > 0) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(i + 1, params.get(i));
				}
			}
			rs = pstmt.executeQuery();
			if (rs != null) {
				list = new ArrayList<SpProduct>();
				SpProduct pro = null;
				while (rs.next()) {
					pro = new SpProduct();
					list.add(pro);

					pro.setPrTitle(rs.getString("pr_title"));
					pro.setPrCtId(rs.getInt("pr_ct_id"));
					pro.setPrDetailDesc(rs.getString("pr_detail_desc"));
					pro.setPrId(rs.getInt("pr_id"));
					pro.setPrPrice(rs.getDouble("pr_price"));
					pro.setPrSimpleDesc(rs.getString("pr_simple_desc"));
					pro.setPrAttrs(rs.getString("pr_attrs"));
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

//	Connection conn = dbConn.getConnection();
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	try {
//		
//	}catch(Exception e) {
//		e.printStackTrace();
//		throw new RuntimeException(e);
//	}finally {
//		dbConn.close(conn, pstmt, rs);
//	}
}
