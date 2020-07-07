package edu.xalead;

import com.alibaba.druid.pool.DruidDataSource;
import edu.xalead.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
//@EnableConfigurationProperties(Config.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource(){
        DruidDataSource ds=new DruidDataSource();
//        ds.setDriverClassName();
//        ds.setUsername(jdbc.username);
//        ds.setPassword(jdbc.password);
//        ds.setUrl(jdbc.url);
       return ds;
    }
}
