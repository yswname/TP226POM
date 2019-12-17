package cn.com.ssm.shopping.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.ssm.shopping.config.SpringConfig;
import cn.com.ssm.shopping.entity.SpCatalogue;
import cn.com.ssm.shopping.service.ICatalogueService;
import junit.framework.Assert;

public class TestCatalogueServiceImpl {
    private ICatalogueService cataService;
    @Before
    public void init() {
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
    	this.cataService = ctx.getBean(ICatalogueService.class);
    }
    @Test
    public void testSearchAllCatalogues() {
    	int length = 6;
    	String name = "鞋";
    	
    	List<SpCatalogue> cataList = this.cataService.searchAllCatalogues();
    	int actLength = cataList.size();
    	String actName = cataList.get(5).getCtName();
    	
    	Assert.assertTrue(length==actLength && name.equals(actName));
    }
}
