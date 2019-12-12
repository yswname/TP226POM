package cn.com.demo.javaweb.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.demo.javaweb.shopping.dao.ISpProductDAO;
import cn.com.demo.javaweb.shopping.db.DBConnection;
import cn.com.demo.javaweb.shopping.entity.SpProduct;
import cn.com.demo.mybatis.util.MyBatisUtil;
import cn.com.demo.shopping.mybatis.dao.SpProductMapper;

public class SpProductDAOImpl implements ISpProductDAO {
	private MyBatisUtil util = MyBatisUtil.getInstance();

	@Override
	public List<SpProduct> findByCataId(int cataId) {
		List list = null;
		try {
			SqlSession session = util.getSession();
			SpProductMapper prodMapper = session.getMapper(SpProductMapper.class);
			list = prodMapper.findByCataId(cataId);
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			util.close();
		}
		return list;
	}

	@Override
	public SpProduct findById(int prId) {
		SpProduct pro = null;

		try {
			SqlSession session = util.getSession();
			SpProductMapper prodMapper = session.getMapper(SpProductMapper.class);
			pro = prodMapper.selectByPrimaryKey(prId);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			util.close();
		}
		
		return pro;
	}

	
}
