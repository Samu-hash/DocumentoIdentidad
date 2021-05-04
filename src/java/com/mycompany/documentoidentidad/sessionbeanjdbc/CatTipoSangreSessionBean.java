/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.documentoidentidad.sessionbeanjdbc;

import com.mycompany.documentoidentidad.entities.CatTipoSangreEntities;
import java.util.ArrayList;
import java.util.List;
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
public class CatTipoSangreSessionBean {
    
    private final JdbcTemplate jdbctemplate;

    @Autowired
    public CatTipoSangreSessionBean(DataSource ds) {
        this.jdbctemplate = new JdbcTemplate(ds);
    }
    
    public CatTipoSangreEntities find(int pk) {
        try {
            String sql = "select * from cat_tipo_sangre where id_tipo_sangre = ?";
            return this.jdbctemplate.queryForObject(sql, new Object[]{pk}, new CatTipoSangreEntities());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CatTipoSangreEntities> findAll() {
        try {
            String sql = "select * from cat_tipo_sangre";
            return this.jdbctemplate.query(sql, new CatTipoSangreEntities());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
