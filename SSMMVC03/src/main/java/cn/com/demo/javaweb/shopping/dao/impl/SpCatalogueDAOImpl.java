package cn.com.demo.javaweb.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.com.demo.javaweb.shopping.dao.ISpCatalogueDAO;
import cn.com.demo.javaweb.shopping.db.DBConnection;
import cn.com.demo.javaweb.shopping.entity.SpCatalogue;

public class SpCatalogueDAOImpl implements ISpCatalogueDAO {
	private DBConnection dbConn = DBConnection.getInstance();
	@Override
	public List<SpCatalogue> findAll() {
		List<SpCatalogue> list = null;
		
		Connection conn = dbConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from sp_catalogue";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs != null) {
				list = new ArrayList<SpCatalogue>();
				SpCatalogue cata = null;
				while(rs.next()) {
					cata = new SpCatalogue();
					list.add(cata);
					
					cata.setCtId(rs.getInt("ct_id"));
					cata.setCtName(rs.getString("ct_name"));
					cata.setCtParentId(rs.getInt("ct_parent_id"));
					cata.setCtRemark(rs.getString("ct_remark"));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			dbConn.close(conn, pstmt, rs);
		}
		return list;
	}

}
