package cn.com.demo.javaweb.shopping.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.demo.javaweb.shopping.dao.ISpImageDAO;
import cn.com.demo.javaweb.shopping.entity.SpImage;
import cn.com.demo.mybatis.util.MyBatisUtil;
import cn.com.demo.shopping.mybatis.dao.SpImagesMapper;

public class SpImageDAOImpl implements ISpImageDAO {
	private MyBatisUtil util = MyBatisUtil.getInstance();
	@Override
	public List<SpImage> findImages(int type, int prId) {
		List<SpImage> list = null;
//		String sql = "select * from sp_images where img_type=? and img_pr_id=? order by img_id";
		try {
			SqlSession session = util.getSession();
			SpImagesMapper imagesMapper = session.getMapper(SpImagesMapper.class);
			list = imagesMapper.findImages(type, prId);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			util.close();
		}

		return list;
	}

}
