package com.qf.ssm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * mybatis的SqlSessionFactory
 */

public class MyBatisConfig {

    @Bean("sqlSessionFactory")//把方法返回对象,交给spring管理,可以改名字（bean存到ioc容器的名字），如果没写名字默认方法首字母小写
    public SqlSessionFactory sqlSessionFactory(@Autowired DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //sqlSessionFactory可以创建数据库链接 sqlSession 一定要有数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //别名
        //sqlSessionFactoryBean.setTypeAliasesPackage();
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        //扫描mapper配置
                        .getResources("classpath:mapper/*.xml")
        );
        return sqlSessionFactoryBean.getObject();
    }
    //因为使用mybatis的时候 用的动态代理 完全就只有接口
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //指定要扫描的包  这样spring才知道有哪些dao要动态代理
        mapperScannerConfigurer.setBasePackage("com.qf.ssm.dao");
        return mapperScannerConfigurer;
    }


}
