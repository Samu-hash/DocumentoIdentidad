/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.documentoidentidad.entities;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author samu5
 */
public class DocumentoIdentidadEntitiesReport implements RowMapper<DocumentoIdentidadEntitiesReport> {

    private String idDocumento;
    private String estadoFamiliarEntitie;
    private String tipoSangreEntitie;
    private String profesionEntitie;
    private String departamentoEntities;
    private String municipiosEntities;
    private String nombres;
    private String apellidos;
    private String conocidoPor;
    private String genero;
    private Date fechaNacimiento;
    private String lugarNacimientoEntitieMuni;
    private String lugarNacimientoEntitieDepto;
    private Date fechaExpedicion;
    private String lugarExpedicionEntitiesMuni;
    private String lugarExpedicionEntitiesDepto;
    private Date fechaExpiracion;
    private String residencia;
    private String residenciaEntitieMuni;
    private String residenciaEntitieDepto;
    private String nombreMadre;
    private String nombrePadre;
    private String conyuge;
    private String tramite;
    private String nit;
    private String codidoZona;
    private String estado;
    private Blob foto;

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getEstadoFamiliarEntitie() {
        return estadoFamiliarEntitie;
    }

    public void setEstadoFamiliarEntitie(String estadoFamiliarEntitie) {
        this.estadoFamiliarEntitie = estadoFamiliarEntitie;
    }

    public String getTipoSangreEntitie() {
        return tipoSangreEntitie;
    }

    public void setTipoSangreEntitie(String tipoSangreEntitie) {
        this.tipoSangreEntitie = tipoSangreEntitie;
    }

    public String getProfesionEntitie() {
        return profesionEntitie;
    }

    public void setProfesionEntitie(String profesionEntitie) {
        this.profesionEntitie = profesionEntitie;
    }

    public String getDepartamentoEntities() {
        return departamentoEntities;
    }

    public void setDepartamentoEntities(String departamentoEntities) {
        this.departamentoEntities = departamentoEntities;
    }

    public String getMunicipiosEntities() {
        return municipiosEntities;
    }

    public void setMunicipiosEntities(String municipiosEntities) {
        this.municipiosEntities = municipiosEntities;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getConocidoPor() {
        return conocidoPor;
    }

    public void setConocidoPor(String conocidoPor) {
        this.conocidoPor = conocidoPor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimientoEntitieMuni() {
        return lugarNacimientoEntitieMuni;
    }

    public void setLugarNacimientoEntitieMuni(String lugarNacimientoEntitieMuni) {
        this.lugarNacimientoEntitieMuni = lugarNacimientoEntitieMuni;
    }

    public String getLugarNacimientoEntitieDepto() {
        return lugarNacimientoEntitieDepto;
    }

    public void setLugarNacimientoEntitieDepto(String lugarNacimientoEntitieDepto) {
        this.lugarNacimientoEntitieDepto = lugarNacimientoEntitieDepto;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getLugarExpedicionEntitiesMuni() {
        return lugarExpedicionEntitiesMuni;
    }

    public void setLugarExpedicionEntitiesMuni(String lugarExpedicionEntitiesMuni) {
        this.lugarExpedicionEntitiesMuni = lugarExpedicionEntitiesMuni;
    }

    public String getLugarExpedicionEntitiesDepto() {
        return lugarExpedicionEntitiesDepto;
    }

    public void setLugarExpedicionEntitiesDepto(String lugarExpedicionEntitiesDepto) {
        this.lugarExpedicionEntitiesDepto = lugarExpedicionEntitiesDepto;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getResidenciaEntitieMuni() {
        return residenciaEntitieMuni;
    }

    public void setResidenciaEntitieMuni(String residenciaEntitieMuni) {
        this.residenciaEntitieMuni = residenciaEntitieMuni;
    }

    public String getResidenciaEntitieDepto() {
        return residenciaEntitieDepto;
    }

    public void setResidenciaEntitieDepto(String residenciaEntitieDepto) {
        this.residenciaEntitieDepto = residenciaEntitieDepto;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getConyuge() {
        return conyuge;
    }

    public void setConyuge(String conyuge) {
        this.conyuge = conyuge;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCodidoZona() {
        return codidoZona;
    }

    public void setCodidoZona(String codidoZona) {
        this.codidoZona = codidoZona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    @Override
    public DocumentoIdentidadEntitiesReport mapRow(ResultSet rs, int i) throws SQLException {
        DocumentoIdentidadEntitiesReport doc = new DocumentoIdentidadEntitiesReport();

        doc.setIdDocumento(rs.getString("id_documento"));
        doc.setEstadoFamiliarEntitie(rs.getString("nombre_estado_familiar"));
        doc.setTipoSangreEntitie(rs.getString("tipo_sangre"));
        doc.setProfesionEntitie(rs.getString("nombre_profesion"));
        doc.setDepartamentoEntities(rs.getString("nombre_departamento"));
        doc.setMunicipiosEntities(rs.getString("nombre_municipio"));
        doc.setNombres(rs.getString("nombres"));
        doc.setApellidos(rs.getString("apellidos"));
        doc.setConocidoPor(rs.getString("conocido_por"));
        doc.setGenero(rs.getString("genero"));
        doc.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
        doc.setLugarNacimientoEntitieDepto(rs.getString("nombre_departamento_lugar_nac"));
        doc.setLugarNacimientoEntitieMuni(rs.getString("nombre_municipio_lugar_nac"));
        doc.setFechaExpedicion(rs.getDate("fecha_expedicion"));
        doc.setLugarExpedicionEntitiesDepto(rs.getString("nombre_departamento_fec_exp"));
        doc.setLugarExpedicionEntitiesMuni(rs.getString("nombre_municipio_fec_exp"));
        doc.setFechaExpiracion(rs.getDate("fecha_expiracion"));
        doc.setResidencia(rs.getString("residencia"));
        doc.setResidenciaEntitieDepto(rs.getString("nombre_departamento_residencia"));
        doc.setResidenciaEntitieMuni(rs.getString("nombre_municipio_residencia"));
        doc.setNombreMadre(rs.getString("nombre_completo_madre"));
        doc.setNombrePadre(rs.getString("nombre_completo_padre"));
        doc.setConyuge(rs.getString("conyuge"));
        doc.setTramite(rs.getString("tramite"));
        doc.setNit(rs.getString("nit"));
        doc.setCodidoZona(rs.getString("codigo_zona"));
        doc.setEstado(rs.getString("estado"));
        doc.setFoto(rs.getBlob("url_foto"));
        return doc;
    }

}
