/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.documentoidentidad.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author samu5
 */
public class CatDepartamentosEntities implements RowMapper<CatDepartamentosEntities>{
    
    private int idDepartamento;
    private String nombreDepartamento;

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    @Override
    public String toString() {
        return "CatDepartamentosEntities{" + "idDepartamento=" + idDepartamento + ", nombreDepartamento=" + nombreDepartamento + '}';
    }
    
    @Override
    public CatDepartamentosEntities mapRow(ResultSet rs, int i) throws SQLException {
        CatDepartamentosEntities depto = new CatDepartamentosEntities();
        depto.setIdDepartamento(rs.getInt("id_departamento"));
        depto.setNombreDepartamento(rs.getString("nombre_departamento"));
        return depto;
    }
    
}
