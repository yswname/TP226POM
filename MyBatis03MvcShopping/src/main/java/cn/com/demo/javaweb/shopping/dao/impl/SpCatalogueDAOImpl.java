package cn.com.demo.javaweb.shopping.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.demo.javaweb.shopping.dao.ISpCatalogueDAO;
import cn.com.demo.javaweb.shopping.entity.SpCatalogue;
import cn.com.demo.mybatis.util.MyBatisUtil;
import cn.com.demo.shopping.mybatis.dao.SpCatalogueMapper;

public class SpCatalogueDAOImpl implements ISpCatalogueDAO {
	private MyBatisUtil myBatisUtil = MyBatisUtil.getInstance();
	@Override
	public List<SpCatalogue> findAll() {
		List<SpCatalogue> list = null;
		
		try {
			SqlSession session = myBatisUtil.getSession();
			SpCatalogueMapper catalogueMapper = session.getMapper(SpCatalogueMapper.class);
			list = catalogueMapper.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			myBatisUtil.close();
		}
		
		return list;
	}

}
