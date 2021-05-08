/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.documentoidentidad.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



/**
 *
 * @author samu5
 */
@Configuration
@ComponentScan("com.mycompany.documentoidentidad")
@PropertySource("classpath:com/mycompany/documentoidentidad/util/Parameters.properties")
public class PropertiesConexion {

    @Autowired
    public Environment env;
    
    @Bean
    public DataSource dataSource() throws SQLException {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        try {
            ds.setDriverClassName(env.getRequiredProperty("CLASSNAME"));
        } catch (Exception e) {
            throw new RuntimeException("Error en el driver");
        }
        ds.setUrl(env.getRequiredProperty("URL"));
        System.out.println(env.getRequiredProperty("URL"));
        ds.setUsername(env.getRequiredProperty("USER"));
        ds.setPassword(env.getRequiredProperty("PASSWORD"));
        return ds;
    }
    
}
