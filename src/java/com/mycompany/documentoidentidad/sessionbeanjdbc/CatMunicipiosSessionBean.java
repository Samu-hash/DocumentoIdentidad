/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.documentoidentidad.sessionbeanjdbc;

import com.mycompany.documentoidentidad.entities.CatDepartamentosEntities;
import com.mycompany.documentoidentidad.entities.CatMunicipiosEntities;
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
public class CatMunicipiosSessionBean {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CatMunicipiosSessionBean(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public CatMunicipiosEntities find(int pk) {
        try {
            String sql = "select muni.id_municipio, muni.nombre_municipio, depto.id_departamento, depto.nombre_departamento "
                    + "from cat_municipios muni "
                    + "inner join cat_departamentos depto on(muni.id_departamento = depto.id_departamento) "
                    + "where muni.id_municipio = ?";
            return this.jdbcTemplate.queryForObject(sql, new Object[]{pk}, new CatMunicipiosEntities());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CatMunicipiosEntities> findDepto(String fk) {
        try {
            String sql = "select muni.id_municipio, muni.nombre_municipio, depto.id_departamento, depto.nombre_departamento "
                    + "from cat_municipios muni "
                    + "inner join cat_departamentos depto on(muni.id_departamento = depto.id_departamento) "
                    + "where depto.id_departamento = ?";
            return this.jdbcTemplate.query(sql, new Object[]{fk}, new CatMunicipiosEntities());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<CatMunicipiosEntities> findAll() {
        try {
            String sql = "select muni.id_municipio, muni.nombre_municipio, depto.id_departamento, depto.nombre_departamento "
                    + "from cat_municipios muni "
                    + "inner join cat_departamentos depto on(muni.id_departamento = depto.id_departamento) ";
            return this.jdbcTemplate.query(sql, new CatMunicipiosEntities());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
