package com.hexun.pointQuartz.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 此类为了解决在application.yml中配置mybatis.mapperLocations完全不起作用的问题
 * @author zhoudong
 */
@Configuration
@MapperScan(basePackages = "com.hexun.pointQuartz.mapper")
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        // 设置mybatis的主配置文件
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        //就是这句代码，只能指定单个mapper.xml文件，加通配符的话找不到文件
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:sqlmapper/*.xml"));
        // 配置多个路径使用：sqlSessionFactoryBean.setMapperLocations(new Resource[]{resource1, resource2});
        return sqlSessionFactoryBean.getObject();
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }
}
