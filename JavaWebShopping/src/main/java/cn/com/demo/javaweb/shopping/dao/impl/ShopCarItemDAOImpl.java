package cn.com.demo.javaweb.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.com.demo.javaweb.shopping.dao.IShopCarItemDAO;
import cn.com.demo.javaweb.shopping.db.DBConnection;
import cn.com.demo.javaweb.shopping.entity.SpShopCarItem;

public class ShopCarItemDAOImpl implements IShopCarItemDAO {
	private DBConnection dbConn = DBConnection.getInstance();

	@Override
	public void add(SpShopCarItem item) {
		Connection conn = dbConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into sp_shoper_car_item values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item.getCarItPrId());
			pstmt.setInt(2, item.getCarItNumber());
			pstmt.setInt(3, item.getCarItUrId());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
	}

	@Override
	public void update(SpShopCarItem item) {
		Connection conn = dbConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update sp_shoper_car_item set car_it_number=? where car_it_pr_id=? and car_it_ur_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item.getCarItNumber());
			pstmt.setInt(2, item.getCarItPrId());
			pstmt.setInt(3, item.getCarItUrId());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
	}

	@Override
	public void delete(SpShopCarItem item) {
		Connection conn = dbConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "delete from sp_shoper_car_item where car_it_pr_id=? and car_it_ur_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item.getCarItPrId());
			pstmt.setInt(2, item.getCarItUrId());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
	}

	@Override
	public void deleteByUrId(int urId) {
		Connection conn = dbConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "delete from sp_shoper_car_item where car_it_ur_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, urId);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
	}

	@Override
	public SpShopCarItem findById(int itId) {
		SpShopCarItem item = null;
		Connection conn = dbConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from sp_shoper_car_item where car_it_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, itId);
			
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				item = new SpShopCarItem();
				item.setCarItId(rs.getInt("car_it_id"));
				item.setCarItNumber(rs.getInt("car_it_number"));
				item.setCarItPrId(rs.getInt("car_it_pr_id"));
				item.setCarItUrId(rs.getInt("car_it_ur_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return item;
	}

	@Override
	public List<SpShopCarItem> findByUrId(int urId) {
		List<SpShopCarItem> itemList = null;
		Connection conn = dbConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from sp_shoper_car_item where car_it_ur_id=? order by car_it_id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, urId);
			
			rs = pstmt.executeQuery();
			if (rs != null) {
				itemList = new ArrayList<SpShopCarItem>();
				SpShopCarItem item = null;
				while (rs.next()) {
					item = new SpShopCarItem();
					itemList.add(item);
					item.setCarItId(rs.getInt("car_it_id"));
					item.setCarItNumber(rs.getInt("car_it_number"));
					item.setCarItPrId(rs.getInt("car_it_pr_id"));
					item.setCarItUrId(rs.getInt("car_it_ur_id"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return itemList;
	}

	@Override
	public SpShopCarItem find(int urId, int prId) {
		SpShopCarItem item = null;
		Connection conn = dbConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from sp_shoper_car_item where car_it_ur_id=? and car_it_pr_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, urId);
			pstmt.setInt(2, prId);
			
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				item = new SpShopCarItem();
				item.setCarItId(rs.getInt("car_it_id"));
				item.setCarItNumber(rs.getInt("car_it_number"));
				item.setCarItPrId(rs.getInt("car_it_pr_id"));
				item.setCarItUrId(rs.getInt("car_it_ur_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return item;
	}

}
