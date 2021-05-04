/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.documentoidentidad.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author samu5
 */
public class DocumentoIdentidadEntities implements RowMapper<DocumentoIdentidadEntities> {

    private String idDocumento;
    private CatEstadoFamiliarEnties estadoFamiliarEntitie;
    private CatTipoSangreEntities tipoSangreEntitie;
    private CatProfesionesEntities profesionEntitie;
    private CatMunicipiosEntities municipiosEntities;
    private String nombres;
    private String apellidos;
    private String conocidoPor;
    private String genero;
    private Date fechaNacimiento;
    private CatMunicipiosEntities lugarNacimientoEntitie;
    private Date fechaExpedicion;
    private CatMunicipiosEntities lugarExpedicionEntities;
    private Date fechaExpiracion;
    private String residencia;
    private CatMunicipiosEntities residenciaEntitie;
    private String nombreMadre;
    private String nombrePadre;
    private String conyuge;
    private String tramite;
    private String nit;
    private String codidoZona;
    private String urlFoto;
    private String estado;

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public CatEstadoFamiliarEnties getEstadoFamiliarEntitie() {
        return estadoFamiliarEntitie;
    }

    public void setEstadoFamiliarEntitie(CatEstadoFamiliarEnties estadoFamiliarEntitie) {
        this.estadoFamiliarEntitie = estadoFamiliarEntitie;
    }

    public CatTipoSangreEntities getTipoSangreEntitie() {
        return tipoSangreEntitie;
    }

    public void setTipoSangreEntitie(CatTipoSangreEntities tipoSangreEntitie) {
        this.tipoSangreEntitie = tipoSangreEntitie;
    }

    public CatProfesionesEntities getProfesionEntitie() {
        return profesionEntitie;
    }

    public void setProfesionEntitie(CatProfesionesEntities profesionEntitie) {
        this.profesionEntitie = profesionEntitie;
    }

    public CatMunicipiosEntities getMunicipiosEntities() {
        return municipiosEntities;
    }

    public void setMunicipiosEntities(CatMunicipiosEntities municipiosEntities) {
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

    public CatMunicipiosEntities getLugarNacimientoEntitie() {
        return lugarNacimientoEntitie;
    }

    public void setLugarNacimientoEntitie(CatMunicipiosEntities lugarNacimientoEntitie) {
        this.lugarNacimientoEntitie = lugarNacimientoEntitie;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public CatMunicipiosEntities getLugarExpedicionEntities() {
        return lugarExpedicionEntities;
    }

    public void setLugarExpedicionEntities(CatMunicipiosEntities lugarExpedicionEntities) {
        this.lugarExpedicionEntities = lugarExpedicionEntities;
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

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public CatMunicipiosEntities getResidenciaEntitie() {
        return residenciaEntitie;
    }

    public void setResidenciaEntitie(CatMunicipiosEntities residenciaEntitie) {
        this.residenciaEntitie = residenciaEntitie;
    }

    @Override
    public String toString() {
        return "DocumentoIdentidadEntities{" + "idDocumento=" + idDocumento + ", estadoFamiliarEntitie=" + estadoFamiliarEntitie + ", tipoSangreEntitie=" + tipoSangreEntitie + ", profesionEntitie=" + profesionEntitie + ", municipiosEntities=" + municipiosEntities + ", nombres=" + nombres + ", apellidos=" + apellidos + ", conocidoPor=" + conocidoPor + ", genero=" + genero + ", fechaNacimiento=" + fechaNacimiento + ", lugarNacimientoEntitie=" + lugarNacimientoEntitie + ", fechaExpedicion=" + fechaExpedicion + ", lugarExpedicionEntities=" + lugarExpedicionEntities + ", fechaExpiracion=" + fechaExpiracion + ", residencia=" + residencia + ", residenciaEntitie=" + residenciaEntitie + ", nombreMadre=" + nombreMadre + ", nombrePadre=" + nombrePadre + ", conyuge=" + conyuge + ", tramite=" + tramite + ", nit=" + nit + ", codidoZona=" + codidoZona + ", urlFoto=" + urlFoto + ", estado=" + estado + '}';
    }

    @Override
    public DocumentoIdentidadEntities mapRow(ResultSet rs, int i) throws SQLException {
        DocumentoIdentidadEntities doc = new DocumentoIdentidadEntities();
        CatDepartamentosEntities depto = new CatDepartamentosEntities();
        CatEstadoFamiliarEnties es = new CatEstadoFamiliarEnties();
        CatTipoSangreEntities ts = new CatTipoSangreEntities();
        CatProfesionesEntities pro = new CatProfesionesEntities();
        CatMunicipiosEntities mun = new CatMunicipiosEntities();
        CatMunicipiosEntities nac = new CatMunicipiosEntities();
        CatMunicipiosEntities exp = new CatMunicipiosEntities();
        CatMunicipiosEntities res = new CatMunicipiosEntities();
        
        doc.setIdDocumento(rs.getString("id_documento"));

        es.setIdEstadoFamiliar(rs.getInt("id_estado_familiar"));
        es.setNombreEstadoFamiliar(rs.getString("nombre_estado_familiar"));
        es.setEstado(rs.getString("estado"));
        doc.setEstadoFamiliarEntitie(es);

        ts.setIdTipoSangre(rs.getInt("id_tipo_sangre"));
        ts.setTipoSangre(rs.getString("tipo_sangre"));
        doc.setTipoSangreEntitie(ts);

        pro.setIdProfesiones(rs.getInt("id_profesion"));
        pro.setNombreProfesion(rs.getString("nombre_profesion"));
        pro.setEstado(rs.getString("estado"));
        doc.setProfesionEntitie(pro);

        mun.setIdMunicipio(rs.getInt("id_municipio"));
        depto.setIdDepartamento(rs.getInt("id_departamento"));
        depto.setNombreDepartamento(rs.getString("nombre_departamento"));
        mun.setDepartamentoEntities(depto);
        mun.setNombreMunicipio(rs.getString("nombre_municipio"));
        doc.setMunicipiosEntities(mun);

        doc.setNombres(rs.getString("nombres"));
        doc.setApellidos(rs.getString("apellidos"));
        doc.setConocidoPor(rs.getString("conocido_por"));
        doc.setGenero(rs.getString("genero"));
        doc.setFechaNacimiento(rs.getDate("fecha_nacimiento"));

        
        nac.setIdMunicipio(rs.getInt("id_lugar_nacimiento"));
        depto = new CatDepartamentosEntities();
        depto.setIdDepartamento(rs.getInt("id_depto_lugar_nac"));
        depto.setNombreDepartamento(rs.getString("nombre_departamento_lugar_nac"));
        nac.setDepartamentoEntities(depto);
        nac.setNombreMunicipio(rs.getString("nombre_municipio_lugar_nac"));
        doc.setLugarNacimientoEntitie(nac);

        doc.setFechaExpedicion(rs.getDate("fecha_expedicion"));

        exp.setIdMunicipio(rs.getInt("id_lugar_expedicion"));
        depto = new CatDepartamentosEntities();
        depto.setIdDepartamento(rs.getInt("id_depto_fec_exp"));
        depto.setNombreDepartamento(rs.getString("nombre_departamento_fec_exp"));
        exp.setDepartamentoEntities(depto);
        exp.setNombreMunicipio(rs.getString("nombre_municipio_fec_exp"));
        doc.setLugarExpedicionEntities(exp);

        doc.setFechaExpiracion(rs.getDate("fecha_expiracion"));
        
        doc.setResidencia(rs.getString("residencia"));
        res.setIdMunicipio(rs.getInt("id_residencia"));
        depto = new CatDepartamentosEntities();
        depto.setIdDepartamento(rs.getInt("id_depto_residencia"));
        depto.setNombreDepartamento(rs.getString("nombre_departamento_residencia"));
        res.setDepartamentoEntities(depto);
        res.setNombreMunicipio(rs.getString("nombre_municipio_residencia"));
        doc.setLugarExpedicionEntities(res);
        
        doc.setNombreMadre(rs.getString("nombre_completo_madre"));
        doc.setNombrePadre(rs.getString("nombre_completo_padre"));
        doc.setConyuge(rs.getString("conyuge"));
        doc.setTramite(rs.getString("tramite"));
        doc.setNit(rs.getString("nit"));
        doc.setCodidoZona(rs.getString("codigo_zona"));
        doc.setUrlFoto(rs.getString("url_foto"));
        doc.setEstado(rs.getString("estado"));
        return doc;
    }

}
