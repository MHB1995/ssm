package com.qf.ssm.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 配置spring+mybatis
 */
@Configuration//配置类
@EnableAspectJAutoProxy(proxyTargetClass = true)//支持切面(proxyTargetClass = true) 是否选择cglib动态代理
@EnableTransactionManagement//支持事务
@Import({DataSourceConfig.class, MyBatisConfig.class})
@ComponentScan("com.qf.ssm.service")
public class MainConfig {
}
