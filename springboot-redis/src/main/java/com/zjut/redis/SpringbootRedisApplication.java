package com.zjut.redis;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * spring boot会自动扫描SpringBootApplication注解所在类的同级包
 * EnableScheduling //开启定时任务功能
 */
@EnableScheduling
@SpringBootApplication(exclude=
		{DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class SpringbootRedisApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringbootRedisApplication.class);
		//关闭打印banner
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
}
