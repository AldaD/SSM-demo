package com.jinhu.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages={"com.jinhu.service"})
@MapperScan("com.jinhu.mapper")
public class RootConfig {
	private static final Logger logger = LoggerFactory.getLogger(RootConfig.class);
	
	@Bean
	public DataSource dataSource() throws PropertyVetoException{
		ComboPooledDataSource datasource=new ComboPooledDataSource();
		datasource.setJdbcUrl("jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=utf-8&useSSL=false");
		datasource.setDriverClass("com.mysql.jdbc.Driver");
		datasource.setUser("root");
		datasource.setPassword("123456");
		return datasource;
	}
	
	@Bean
	public DataSourceTransactionManager txManager()throws Exception{
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		return factoryBean.getObject();
	}
}
