package cn.com.demo.spring.anno.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import cn.com.demo.spring.anno.pojo.Pig;
@Component
public class PigFactoryBean implements FactoryBean {

	@Override
	public Object getObject() throws Exception {
		return new Pig();
	}

	@Override
	public Class getObjectType() {
		return Pig.class;
	}

	
}
