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
public class ParametrosEntities implements RowMapper<ParametrosEntities> {

    private String idPrametro;
    private String nombreParametro;
    private String valorParametro;
    private String estadoParametro;

    public String getIdPrametro() {
        return idPrametro;
    }

    public void setIdPrametro(String idPrametro) {
        this.idPrametro = idPrametro;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    public String getValorParametro() {
        return valorParametro;
    }

    public void setValorParametro(String valorParametro) {
        this.valorParametro = valorParametro;
    }

    public String getEstadoParametro() {
        return estadoParametro;
    }

    public void setEstadoParametro(String estadoParametro) {
        this.estadoParametro = estadoParametro;
    }

    @Override
    public String toString() {
        return "ParametrosEntities{" + "idPrametro=" + idPrametro + ", nombreParametro=" + nombreParametro + ", valorParametro=" + valorParametro + ", estadoParametro=" + estadoParametro + '}';
    }

    @Override
    public ParametrosEntities mapRow(ResultSet rs, int i) throws SQLException {
        ParametrosEntities paramEntities = new ParametrosEntities();
        paramEntities.setIdPrametro(rs.getString("id_parametro"));
        paramEntities.setNombreParametro(rs.getString("nombre_parametro"));
        paramEntities.setValorParametro(rs.getString("valor_parametro"));
        paramEntities.setEstadoParametro(rs.getString("estado_parametro"));
        return paramEntities;
    }

}
