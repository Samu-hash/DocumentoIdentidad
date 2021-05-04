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
public class CatEstadoFamiliarEnties implements RowMapper<CatEstadoFamiliarEnties> {

    private int idEstadoFamiliar;
    private String nombreEstadoFamiliar;
    private String estado;

    public int getIdEstadoFamiliar() {
        return idEstadoFamiliar;
    }

    public void setIdEstadoFamiliar(int idEstadoFamiliar) {
        this.idEstadoFamiliar = idEstadoFamiliar;
    }

    public String getNombreEstadoFamiliar() {
        return nombreEstadoFamiliar;
    }

    public void setNombreEstadoFamiliar(String nombreEstadoFamiliar) {
        this.nombreEstadoFamiliar = nombreEstadoFamiliar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CatEstadoFamiliarEnties{" + "idEstadoFamiliar=" + idEstadoFamiliar + ", nombreEstadoFamiliar=" + nombreEstadoFamiliar + ", estado=" + estado + '}';
    }

    @Override
    public CatEstadoFamiliarEnties mapRow(ResultSet rs, int i) throws SQLException {
        CatEstadoFamiliarEnties estFamiliar = new CatEstadoFamiliarEnties();
        estFamiliar.setIdEstadoFamiliar(rs.getInt("id_estado_familiar"));
        estFamiliar.setNombreEstadoFamiliar(rs.getString("nombre_estado_familiar"));
        estFamiliar.setEstado(rs.getString("estado"));
        return estFamiliar;
    }

}
