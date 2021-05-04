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
public class CatTipoSangreEntities implements RowMapper<CatTipoSangreEntities> {
    
    private int idTipoSangre;
    private String tipoSangre;
    
    public int getIdTipoSangre() {
        return idTipoSangre;
    }
    
    public void setIdTipoSangre(int idTipoSangre) {
        this.idTipoSangre = idTipoSangre;
    }
    
    public String getTipoSangre() {
        return tipoSangre;
    }
    
    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
    
    @Override
    public String toString() {
        return "CatTipoSangreEntities{" + "idTipoSangre=" + idTipoSangre + ", tipoSangre=" + tipoSangre + '}';
    }
    
    @Override
    public CatTipoSangreEntities mapRow(ResultSet rs, int i) throws SQLException {
        CatTipoSangreEntities tSangre = new CatTipoSangreEntities();
        tSangre.setIdTipoSangre(rs.getInt("id_tipo_sangre"));
        tSangre.setTipoSangre(rs.getString("tipo_sangre"));
        return tSangre;
    }
    
}
