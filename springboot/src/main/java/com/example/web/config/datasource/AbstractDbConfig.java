package com.example.web.config.datasource;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-03-09
 **/
public abstract class AbstractDbConfig {

    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, String mapperLocation) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        Resource[] resource= resourceResolver.getResources(mapperLocation);
        factoryBean.setMapperLocations(resource);
        return factoryBean.getObject();
    }

    public DataSource dataSourceFactory(String driveClassName, String url, String userName, String password){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setDriverClassName(driveClassName);
        datasource.setUrl(url);
        datasource.setUsername(userName);
        datasource.setPassword(password);
//        try {
//            datasource.setFilters("log4j");
//        } catch (Exception e) {
//
//        }
        datasource.setProxyFilters(getFilters());
        datasource.setMaxActive(10);
        datasource.setInitialSize(10);
        datasource.setMaxWait(60000);
        datasource.setMinIdle(1);
        datasource.setTimeBetweenEvictionRunsMillis(60000);
        datasource.setMinEvictableIdleTimeMillis(300000);
        datasource.setTestWhileIdle(true);
        datasource.setTestOnBorrow(false);
        datasource.setTestOnReturn(false);
        datasource.setPoolPreparedStatements(true);
        datasource.setMaxOpenPreparedStatements(10);
        datasource.setUseGlobalDataSourceStat(true);
        return datasource;
    }

    protected List<Filter> getFilters(){
        List<Filter> filters = new ArrayList<>(1);

        StatFilter filter= new StatFilter();
        filter.setLogSlowSql(true);
        filter.setSlowSqlMillis(10000);
        filter.setMergeSql(true);
        filters.add(filter);
        return filters;
    }
}
