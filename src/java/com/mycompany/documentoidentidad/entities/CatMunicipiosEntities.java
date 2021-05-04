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
public class CatMunicipiosEntities implements RowMapper<CatMunicipiosEntities> {

    private int idMunicipio;
    private CatDepartamentosEntities departamentoEntities;
    private String nombreMunicipio;

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public CatDepartamentosEntities getDepartamentoEntities() {
        return departamentoEntities;
    }

    public void setDepartamentoEntities(CatDepartamentosEntities departamentoEntities) {
        this.departamentoEntities = departamentoEntities;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    @Override
    public String toString() {
        return "CatMunicipiosEntities{" + "idMunicipio=" + idMunicipio + ", idDepartamento=" + departamentoEntities + ", nombreMunicipio=" + nombreMunicipio + '}';
    }

    @Override
    public CatMunicipiosEntities mapRow(ResultSet rs, int i) throws SQLException {
        CatMunicipiosEntities muni = new CatMunicipiosEntities();
        CatDepartamentosEntities depto = new CatDepartamentosEntities();
        muni.setIdMunicipio(rs.getInt("id_municipio"));

        depto.setIdDepartamento(rs.getInt("id_departamento"));
        depto.setNombreDepartamento(rs.getString("nombre_departamento"));

        muni.setDepartamentoEntities(depto);
        muni.setNombreMunicipio(rs.getString("nombre_municipio"));
        return muni;
    }

}
