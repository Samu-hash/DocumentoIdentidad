/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.documentoidentidad.sessionbeanjdbc;

import com.mycompany.documentoidentidad.entities.DocumentoIdentidadEntities;
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
public class DocumentoIdentidadSessionBean {

    private final JdbcTemplate jdbctemplate;

    @Autowired
    public DocumentoIdentidadSessionBean(DataSource ds) {
        this.jdbctemplate = new JdbcTemplate(ds);
    }

    public DocumentoIdentidadEntities find(String pk) {
        try {
            String sql = "SELECT doc.*, "
                    + "fam.id_estado_familiar, fam.nombre_estado_familiar, fam.estado, "
                    + "ts.id_tipo_sangre, ts.tipo_sangre, "
                    + "pro.id_profesion, pro.nombre_profesion, pro.estado, "
                    + "muni.id_municipio, depto.id_departamento, depto.nombre_departamento, muni.nombre_municipio,  "
                    + "deptoNac.id_departamento as id_depto_lugar_nac, deptoNac.nombre_departamento as nombre_departamento_lugar_nac, "
                    + "muniNac.nombre_municipio as nombre_municipio_lugar_nac, "
                    + "deptoExp.id_departamento AS id_depto_fec_exp, deptoExp.nombre_departamento AS nombre_departamento_fec_exp, "
                    + "muniExp.nombre_municipio AS nombre_municipio_fec_exp "
                    + "FROM documento_identidad doc "
                    + "INNER JOIN cat_estado_familiar fam ON(doc.id_estado_familiar =  fam.id_estado_familiar) "
                    + "INNER JOIN cat_tipo_sangre ts ON(doc.id_tipo_sangre = ts.id_tipo_sangre) "
                    + "INNER JOIN cat_profesiones pro ON(doc.id_profesion =  pro.id_profesion) "
                    + "LEFT JOIN cat_municipios muni ON(doc.id_municipio = muni.id_municipio) "
                    + "LEFT JOIN cat_departamentos depto ON(muni.id_municipio = depto.id_departamento) "
                    + "LEFT JOIN cat_municipios muniNac ON(doc.id_lugar_nacimiento = muniNac.id_municipio) "
                    + "LEFT JOIN cat_departamentos deptoNac ON(muniNac.id_municipio = deptoNac.id_departamento) "
                    + "LEFT JOIN cat_municipios muniExp ON(doc.id_lugar_expedicion = muniExp.id_municipio) "
                    + "LEFT JOIN cat_departamentos deptoExp ON(muniExp.id_municipio = deptoExp.id_departamento) "
                    + "LEFT JOIN cat_municipios muniRes ON(doc.id_lugar_expedicion = muniRes.id_municipio) "
                    + "LEFT JOIN cat_departamentos deptoRes ON(muniRes.id_municipio = deptoRes.id_departamento) "
                    + "WHERE doc.estado ='A' and doc.id_documento = ?";
            return this.jdbctemplate.queryForObject(sql, new Object[]{pk}, new DocumentoIdentidadEntities());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<DocumentoIdentidadEntities> findAll() {
        try {
            String sql = "SELECT doc.*, "
                    + "fam.id_estado_familiar, fam.nombre_estado_familiar, fam.estado, "
                    + "ts.id_tipo_sangre, ts.tipo_sangre, "
                    + "pro.id_profesion, pro.nombre_profesion, pro.estado, "
                    + "muni.id_municipio, depto.id_departamento, depto.nombre_departamento, muni.nombre_municipio, "
                    + "deptoNac.id_departamento as id_depto_lugar_nac, deptoNac.nombre_departamento as nombre_departamento_lugar_nac,"
                    + "muniNac.nombre_municipio as nombre_municipio_lugar_nac,"
                    + "deptoExp.id_departamento AS id_depto_fec_exp, deptoExp.nombre_departamento AS nombre_departamento_fec_exp,"
                    + "muniExp.nombre_municipio AS nombre_municipio_fec_exp,"
                    + "deptoRes.id_departamento AS id_depto_residencia, deptoRes.nombre_departamento AS nombre_departamento_residencia, "
                    + "muniRes.nombre_municipio AS nombre_municipio_residencia "
                    + "FROM documento_identidad doc "
                    + "INNER JOIN cat_estado_familiar fam ON(doc.id_estado_familiar =  fam.id_estado_familiar) "
                    + "INNER JOIN cat_tipo_sangre ts ON(doc.id_tipo_sangre = ts.id_tipo_sangre) "
                    + "INNER JOIN cat_profesiones pro ON(doc.id_profesion =  pro.id_profesion) "
                    + "LEFT JOIN cat_municipios muni ON(doc.id_municipio = muni.id_municipio) "
                    + "LEFT JOIN cat_departamentos depto ON(muni.id_municipio = depto.id_departamento) "
                    + "LEFT JOIN cat_municipios muniNac ON(doc.id_lugar_nacimiento = muniNac.id_municipio) "
                    + "LEFT JOIN cat_departamentos deptoNac ON(muniNac.id_municipio = deptoNac.id_departamento) "
                    + "LEFT JOIN cat_municipios muniExp ON(doc.id_lugar_expedicion = muniExp.id_municipio)"
                    + "LEFT JOIN cat_departamentos deptoExp ON(muniExp.id_municipio = deptoExp.id_departamento) "
                    + "LEFT JOIN cat_municipios muniRes ON(doc.id_residencia = muniRes.id_municipio) "
                    + "LEFT JOIN cat_departamentos deptoRes ON(muniRes.id_municipio = deptoRes.id_departamento) "
                    + "WHERE doc.estado ='A'";
            return this.jdbctemplate.query(sql, new DocumentoIdentidadEntities());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<DocumentoIdentidadEntities> findAllName(String textoBusqueda) {
        try {
            String sql = "SELECT doc.*, "
                    + "fam.id_estado_familiar, fam.nombre_estado_familiar, fam.estado, "
                    + "ts.id_tipo_sangre, ts.tipo_sangre, "
                    + "pro.id_profesion, pro.nombre_profesion, pro.estado, "
                    + "muni.id_municipio, depto.id_departamento, depto.nombre_departamento, muni.nombre_municipio, "
                    + "deptoNac.id_departamento as id_depto_lugar_nac, deptoNac.nombre_departamento as nombre_departamento_lugar_nac,"
                    + "muniNac.nombre_municipio as nombre_municipio_lugar_nac,"
                    + "deptoExp.id_departamento AS id_depto_fec_exp, deptoExp.nombre_departamento AS nombre_departamento_fec_exp,"
                    + "muniExp.nombre_municipio AS nombre_municipio_fec_exp,"
                    + "deptoRes.id_departamento AS id_depto_residencia, deptoRes.nombre_departamento AS nombre_departamento_residencia, "
                    + "muniRes.nombre_municipio AS nombre_municipio_residencia "
                    + "FROM documento_identidad doc "
                    + "INNER JOIN cat_estado_familiar fam ON(doc.id_estado_familiar =  fam.id_estado_familiar) "
                    + "INNER JOIN cat_tipo_sangre ts ON(doc.id_tipo_sangre = ts.id_tipo_sangre) "
                    + "INNER JOIN cat_profesiones pro ON(doc.id_profesion =  pro.id_profesion) "
                    + "LEFT JOIN cat_municipios muni ON(doc.id_municipio = muni.id_municipio) "
                    + "LEFT JOIN cat_departamentos depto ON(muni.id_municipio = depto.id_departamento) "
                    + "LEFT JOIN cat_municipios muniNac ON(doc.id_lugar_nacimiento = muniNac.id_municipio) "
                    + "LEFT JOIN cat_departamentos deptoNac ON(muniNac.id_municipio = deptoNac.id_departamento) "
                    + "LEFT JOIN cat_municipios muniExp ON(doc.id_lugar_expedicion = muniExp.id_municipio)"
                    + "LEFT JOIN cat_departamentos deptoExp ON(muniExp.id_municipio = deptoExp.id_departamento) "
                    + "LEFT JOIN cat_municipios muniRes ON(doc.id_residencia = muniRes.id_municipio) "
                    + "LEFT JOIN cat_departamentos deptoRes ON(muniRes.id_municipio = deptoRes.id_departamento) "
                    + "WHERE doc.estado ='A' and doc.nombres like '%" + textoBusqueda + "%'  ";
            return this.jdbctemplate.query(sql, new DocumentoIdentidadEntities());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<DocumentoIdentidadEntities> findAllDocumento(String textoBusqueda) {
        try {
            String sql = "SELECT doc.*, "
                    + "fam.id_estado_familiar, fam.nombre_estado_familiar, fam.estado, "
                    + "ts.id_tipo_sangre, ts.tipo_sangre, "
                    + "pro.id_profesion, pro.nombre_profesion, pro.estado, "
                    + "muni.id_municipio, depto.id_departamento, depto.nombre_departamento, muni.nombre_municipio, "
                    + "deptoNac.id_departamento as id_depto_lugar_nac, deptoNac.nombre_departamento as nombre_departamento_lugar_nac,"
                    + "muniNac.nombre_municipio as nombre_municipio_lugar_nac,"
                    + "deptoExp.id_departamento AS id_depto_fec_exp, deptoExp.nombre_departamento AS nombre_departamento_fec_exp,"
                    + "muniExp.nombre_municipio AS nombre_municipio_fec_exp,"
                    + "deptoRes.id_departamento AS id_depto_residencia, deptoRes.nombre_departamento AS nombre_departamento_residencia, "
                    + "muniRes.nombre_municipio AS nombre_municipio_residencia "
                    + "FROM documento_identidad doc "
                    + "INNER JOIN cat_estado_familiar fam ON(doc.id_estado_familiar =  fam.id_estado_familiar) "
                    + "INNER JOIN cat_tipo_sangre ts ON(doc.id_tipo_sangre = ts.id_tipo_sangre) "
                    + "INNER JOIN cat_profesiones pro ON(doc.id_profesion =  pro.id_profesion) "
                    + "LEFT JOIN cat_municipios muni ON(doc.id_municipio = muni.id_municipio) "
                    + "LEFT JOIN cat_departamentos depto ON(muni.id_municipio = depto.id_departamento) "
                    + "LEFT JOIN cat_municipios muniNac ON(doc.id_lugar_nacimiento = muniNac.id_municipio) "
                    + "LEFT JOIN cat_departamentos deptoNac ON(muniNac.id_municipio = deptoNac.id_departamento) "
                    + "LEFT JOIN cat_municipios muniExp ON(doc.id_lugar_expedicion = muniExp.id_municipio)"
                    + "LEFT JOIN cat_departamentos deptoExp ON(muniExp.id_municipio = deptoExp.id_departamento) "
                    + "LEFT JOIN cat_municipios muniRes ON(doc.id_residencia = muniRes.id_municipio) "
                    + "LEFT JOIN cat_departamentos deptoRes ON(muniRes.id_municipio = deptoRes.id_departamento) "
                    + "WHERE doc.estado ='A' and doc.id_documento like'%" + textoBusqueda + "%'";
            return this.jdbctemplate.query(sql, new DocumentoIdentidadEntities());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static java.sql.Date convertir(java.util.Date fechaUtilDate) {
        return new java.sql.Date(fechaUtilDate.getTime());
    }

    public boolean saveDocumento(DocumentoIdentidadEntities doc) {
        try {
            String sql = "insert into documento_identidad("
                    + "id_documento, id_estado_familiar, id_tipo_sangre, id_profesion, id_municipio, "
                    + "nombres, apellidos, conocido_por, genero, fecha_nacimiento, id_lugar_nacimiento, "
                    + "fecha_expedicion, id_lugar_expedicion, fecha_expiracion, residencia, id_residencia, "
                    + "nombre_completo_madre, nombre_completo_padre, conyuge, tramite, nit, codigo_zona, "
                    + "url_foto, estado"
                    + ") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return this.jdbctemplate.update(sql, new Object[]{
                doc.getIdDocumento(), doc.getEstadoFamiliarEntitie().getIdEstadoFamiliar(), doc.getTipoSangreEntitie().getIdTipoSangre(),
                doc.getProfesionEntitie().getIdProfesiones(), doc.getMunicipiosEntities().getIdMunicipio(),
                doc.getNombres(), doc.getApellidos(), doc.getConocidoPor(), doc.getGenero(), doc.getFechaNacimiento(), doc.getLugarNacimientoEntitie().getIdMunicipio(),
                DocumentoIdentidadSessionBean.convertir(doc.getFechaExpedicion()), doc.getLugarExpedicionEntities().getIdMunicipio(), DocumentoIdentidadSessionBean.convertir(doc.getFechaExpiracion()),
                doc.getResidencia(), doc.getResidenciaEntitie().getIdMunicipio(), doc.getNombreMadre(), doc.getNombrePadre(), doc.getConyuge(), doc.getTramite(), doc.getNit(), doc.getCodidoZona(),
                doc.getUrlFoto(), doc.getEstado()
            }) > 0;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDocumento(DocumentoIdentidadEntities doc) {
        try {
            String sql = "update documento_identidad set "
                    + "id_estado_familiar = ?, id_profesion = ?, id_municipio = ?, "
                    + "conocido_por = ?, fecha_expedicion = ?, id_lugar_expedicion = ?, "
                    + "fecha_expiracion = ?, residencia = ?, id_residencia = ?, "
                    + "nombre_completo_madre = ?, nombre_completo_padre = ?, conyuge = ?, nit = ?, codigo_zona = ?, "
                    + "url_foto = ? where id_documento = ? ";
            return this.jdbctemplate.update(sql, new Object[]{
                doc.getEstadoFamiliarEntitie().getIdEstadoFamiliar(), doc.getProfesionEntitie().getIdProfesiones(), doc.getMunicipiosEntities().getIdMunicipio(),
                doc.getConocidoPor(), doc.getFechaExpedicion(), doc.getLugarExpedicionEntities().getIdMunicipio(), 
                doc.getFechaExpiracion(), doc.getResidencia(), doc.getResidenciaEntitie().getIdMunicipio(), 
                doc.getNombreMadre(), doc.getNombrePadre(), doc.getConyuge(), doc.getNit(), doc.getCodidoZona(),
                doc.getUrlFoto(), doc.getIdDocumento()
            }) > 0;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDocumento(String pk, String eliminarRegistro) {
        try {
            String sql;
            if (eliminarRegistro.equals("N")) {
                sql = "update documento_identidad set estado = 'I' where id_documento = ?";
            } else {
                sql = "delete from documento_identidad where id_documento = ?";
            }
            return this.jdbctemplate.update(sql, new Object[]{pk}) > 0;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

}
