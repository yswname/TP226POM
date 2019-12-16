package cn.com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.demo.spring.anno.config.SpringConfig;
import cn.com.demo.spring.anno.pojo.Cat;
import cn.com.demo.spring.anno.pojo.Dog;
import cn.com.demo.spring.anno.pojo.Zoo;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//		Dog dog = ctx.getBean(Dog.class);
//		System.out.println(dog);
//		//System.out.println(ctx.getBean(Cat.class));
//		
//		Zoo zoo = ctx.getBean(Zoo.class);
//		System.out.println(zoo.getDog() +",,,,,,");
		
		String[] names = ctx.getBeanDefinitionNames();
		for(String name:names) {
			System.out.println(name);
		}
		//System.out.println(ctx.getBean("cat")==ctx.getBean(Zoo.class).getCat());
		//System.out.println(ctx.getBean("myCat")==ctx.getBean(Zoo.class).getCat());
		System.out.println(ctx.getBean("pigFactoryBean"));
	}

}
