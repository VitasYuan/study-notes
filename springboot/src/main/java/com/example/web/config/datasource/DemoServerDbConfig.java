package com.example.web.config.datasource;

import com.example.web.annotation.DemoServerMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author yuanweipeng
 * @date 2018-03-08
 **/
@Configuration
@MapperScan(basePackages = {"com.example"},annotationClass = DemoServerMapper.class,
         sqlSessionTemplateRef = "demoServerSqlTemplate")
public class DemoServerDbConfig extends AbstractDbConfig{

    @Value("${spring.datasource.demo.server.url}")
    private String url;

    @Value("${spring.datasource.demo.server.username}")
    private String userName;

    @Value("${spring.datasource.demo.server.password}")
    private String password;

    @Value("${spring.datasource.demo.server.driver-class-name}")
    private String driveClassName;

    @Value(value = "${mybatis.demo.server.mapper-location}")
    private String mapperLocation;

    @Bean(name = "demoServer")
    @Primary
    public DataSource primaryDataSource (){
        return dataSourceFactory(driveClassName, url, userName, password);
    }

    @Bean(name = "demoServerSqlTemplate")
    public SqlSessionTemplate demoServerSqlTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory(primaryDataSource(), mapperLocation));
    }

    @Bean
    @Qualifier("demoServerTransaction")
    public PlatformTransactionManager demoServerTransactionManager(){
        return new DataSourceTransactionManager(primaryDataSource());
    }

}
