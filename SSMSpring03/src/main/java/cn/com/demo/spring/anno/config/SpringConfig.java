package cn.com.demo.spring.anno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cn.com.demo.spring.anno.pojo.Cat;
import cn.com.demo.spring.anno.pojo.Dog;

@Configuration
@ComponentScan(basePackages= {"cn.com.demo.spring.anno.pojo"})
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
