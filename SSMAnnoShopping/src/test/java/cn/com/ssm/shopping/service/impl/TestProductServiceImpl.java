package cn.com.ssm.shopping.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.ssm.shopping.config.SpringConfig;
import cn.com.ssm.shopping.entity.SpProduct;
import cn.com.ssm.shopping.mapper.SpImagesMapper;
import cn.com.ssm.shopping.service.IProductService;
import junit.framework.Assert;

public class TestProductServiceImpl {
	private IProductService proService;
	private SpImagesMapper imagesMapper;

	@Before
	public void init() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		proService = ctx.getBean(IProductService.class);
		this.imagesMapper = ctx.getBean(SpImagesMapper.class);
	}
	@Test
	public void testSearchById() {
		SpProduct pro = this.proService.searchById(1);
		String imgUrl = "s1.jpg";
		Assert.assertEquals(imgUrl, pro.getListPic().getImgUrl());
	}
	@Test
	public void testSearchProductListByCate() {
		List<SpProduct> proList = this.proService.searchProductListByCate(2);
		double price = 1800;
		Assert.assertTrue(proList.size()==1 && proList.get(0).getPrPrice()==price);
	}
}
