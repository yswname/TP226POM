package cn.com.demo.javaweb.tp11.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DbInfo {
    String userName();
    String password();
    String url();
    String driverName();
    
    int age() default 10;
}
