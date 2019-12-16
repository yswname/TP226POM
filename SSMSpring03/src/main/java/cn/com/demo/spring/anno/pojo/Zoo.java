package cn.com.demo.spring.anno.pojo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Zoo {
	//@Autowired// 自动装配 byType
	//@Qualifier("myCat")
	@Resource
    private Cat cat;
	
    private Dog dog;
	public void setCat(Cat cat) {
		this.cat = cat;
	}
	@Autowired
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	public Cat getCat() {
		return cat;
	}
	public Dog getDog() {
		return dog;
	} 
	
}
