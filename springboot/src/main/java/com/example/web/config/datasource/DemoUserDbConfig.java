package com.example.web.config.datasource;

import com.example.web.annotation.DemoUserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author yuanweipeng
 * @date 2018-03-08
 **/
@Configuration
@MapperScan(basePackages = {"com.example"},annotationClass = DemoUserMapper.class,
       sqlSessionTemplateRef = "demoUserTemplate")
public class DemoUserDbConfig extends AbstractDbConfig {

    @Value("${spring.datasource.demo.user.url}")
    private String url;

    @Value("${spring.datasource.demo.user.username}")
    private String userName;

    @Value("${spring.datasource.demo.user.password}")
    private String password;

    @Value("${spring.datasource.demo.user.driver-class-name}")
    private String driveClassName;

    @Value(value = "${mybatis.demo.user.mapper-location}")
    private String mapperLocation;


    @Bean(name = "demoUser")
    public DataSource secondaryDataSource() {
        return dataSourceFactory(driveClassName, url, userName, password);
    }

    @Bean(name = "demoUserTemplate")
    public SqlSessionTemplate demoUserSqlTemplate() throws Exception {
        return new SqlSessionTemplate((sqlSessionFactory(secondaryDataSource(), mapperLocation)));
    }

    @Bean
    @Qualifier("demoUserTransaction")
    public PlatformTransactionManager demoUserTransaction() {
        return new DataSourceTransactionManager(secondaryDataSource());
    }
}
