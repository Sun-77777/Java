package edu.xalead.config;


import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
//@ConfigurationProperties(prefix = "jdbc")
public class Config {

    private String driverClass;
    private String url;
    private  String username;
    private String password;
    static class AAA{
        static int aa;
        static int bb;
    }



}
