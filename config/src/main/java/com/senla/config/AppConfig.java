package com.senla.config;

import com.senla.model.entity.*;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScans(value = {@ComponentScan("com.senla")})
public class AppConfig {

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.senla.network.model");
        sessionFactory.setAnnotatedClasses(User.class, PublicMessage.class, PrivateMessage.class, News.class, Friend.class, Forum.class, Info.class);
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        return hibernateProperties;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb_test");
        dataSource.setUsername("root");
        dataSource.setPassword("VisionMalaxy");
        return dataSource;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        return new HibernateTransactionManager(getSessionFactory().getObject());
    }

}
