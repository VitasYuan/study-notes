package com.example;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * spring boot会自动扫描SpringBootApplication注解所在类的同级包
 * EnableScheduling //开启定时任务功能
 */
@SpringBootApplication
@ServletComponentScan(basePackages = {"com.example.web.config","com.example.web.servlet","com.example.web.listener"})
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringbootApplication.class);
		//关闭打印banner
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
}
