/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.documentoidentidad.sessionbeanjdbc;

import com.mycompany.documentoidentidad.entities.CatDepartamentosEntities;
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
public class CatDepartamentosSessionBean {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CatDepartamentosSessionBean(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public CatDepartamentosEntities find(int pk) {
        try {
            String sql = "select * from cat_departamentos where id_departamento = ?";
            return this.jdbcTemplate.queryForObject(sql, new Object[]{pk}, new CatDepartamentosEntities());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CatDepartamentosEntities> finAll() {
        try {
            String sql = "select * from cat_departamentos";
            return this.jdbcTemplate.query(sql, new CatDepartamentosEntities());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }
}
