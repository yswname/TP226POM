package cn.com.demo.spring.anno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import cn.com.demo.spring.anno.pojo.Cat;
import cn.com.demo.spring.anno.pojo.Dog;
import cn.com.demo.spring.anno.pojo.Tiger;
import cn.com.demo.spring.anno.processor.MyBeanDefinitionPostProcessor;
import cn.com.demo.spring.anno.selector.DemoSelector;

@Configuration
@ComponentScan(basePackages= {"cn.com.demo.spring.anno.pojo","cn.com.demo.spring.anno.factorybean"})
@Import(value= {Tiger.class, DemoSelector.class, MyBeanDefinitionPostProcessor.class})
public class SpringConfig {
	@Bean
    public Dog createDog() {
    	return new Dog();
    }
	
	@Bean("myCat")
	public Cat createCat() {
		return new Cat();
	}
}
