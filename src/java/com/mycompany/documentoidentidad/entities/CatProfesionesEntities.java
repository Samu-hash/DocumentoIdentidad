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
public class CatProfesionesEntities implements RowMapper<CatProfesionesEntities> {
    
    private int idProfesiones;
    private String nombreProfesion;
    private String estado;
    
    public int getIdProfesiones() {
        return idProfesiones;
    }
    
    public void setIdProfesiones(int idProfesiones) {
        this.idProfesiones = idProfesiones;
    }
    
    public String getNombreProfesion() {
        return nombreProfesion;
    }
    
    public void setNombreProfesion(String nombreProfesion) {
        this.nombreProfesion = nombreProfesion;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "CatProfesionesEntities{" + "idProfesiones=" + idProfesiones + ", nombreProfesion=" + nombreProfesion + ", estado=" + estado + '}';
    }
    
    @Override
    public CatProfesionesEntities mapRow(ResultSet rs, int i) throws SQLException {
        CatProfesionesEntities profesion = new CatProfesionesEntities();
        profesion.setIdProfesiones(rs.getInt("id_profesion"));
        profesion.setNombreProfesion(rs.getString("nombre_profesion"));
        profesion.setEstado(rs.getString("estado"));
        return profesion;
    }
    
}
