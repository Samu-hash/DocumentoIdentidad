/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.documentoidentidad.sessionbeanjdbc;

import com.mycompany.documentoidentidad.entities.ParametrosEntities;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author samu5
 */
@Component
@ComponentScan("com.mycompany.documentoidentidad")
public class ParametroSessionBean {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ParametroSessionBean(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public ParametrosEntities find(Object pk) {
        try {
            String query = "select * from parametros where id_parametro = ?";
            return this.jdbcTemplate.queryForObject(query, new Object[]{pk.toString()}, new ParametrosEntities());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ParametrosEntities();
        }
    }

}
