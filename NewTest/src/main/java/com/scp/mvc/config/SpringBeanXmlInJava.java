package com.scp.mvc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.scp.*") //scans stereotypes-- cntrl,serv,repo,comp,confi
@PropertySource(value = { "classpath:database.properties" })
public class SpringBeanXmlInJava {

	@Value("${jdbc.driverClassName}")String driverClassName;
	@Value("${jdbc.url}")String dbUrl;
	@Value("${jdbc.username}")String dbUserName;
	@Value("${jdbc.password}")String password;
	@Value("${hibernate.dialect}")String hbmDialectPropertyValue;
    @Value("${hibernate.show_sql}")String hbmShowSqlPropertyValue;
    @Value("${hibernate.format_sql}")String hbmFormatSqlPropertyValue;
    @Value("${hibernate.ddl}")String hbmDdlAutoPropertyValue;
	
    static{
    	System.out.println("Loading of SpringBeanXmlInJava");
    }
	String hbmDialectProperty = "hibernate.dialect";
    String hbmShowSqlProperty = "hibernate.show_sql";
    String hbmFormatSqlProperty = "hibernate.format_sql";
    String hbmDdlAutoProperty = "hibernate.hbm2ddl.auto";
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        System.out.println("driverClassName : "+driverClassName);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUserName);
        dataSource.setPassword(password);
        System.out.println("data source");
        return dataSource;
    }
    
    @Bean("sf")
    public LocalSessionFactoryBean sFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.scp.*" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        System.out.println("session factory");
        return sessionFactory;
     }
    
   
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(hbmDialectProperty,  hbmDialectPropertyValue);
        properties.put(hbmShowSqlProperty,hbmShowSqlPropertyValue);
        properties.put(hbmFormatSqlProperty,hbmFormatSqlPropertyValue);
        properties.put(hbmDdlAutoProperty,hbmDdlAutoPropertyValue);
        return properties;        
    }
	
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
 System.out.println("view resolver");
        return viewResolver;
    }
    
}


