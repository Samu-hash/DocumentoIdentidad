/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.documentoidentidad.controller;

import com.mycompany.documentoidentidad.entities.CatDepartamentosEntities;
import com.mycompany.documentoidentidad.entities.CatEstadoFamiliarEnties;
import com.mycompany.documentoidentidad.entities.CatMunicipiosEntities;
import com.mycompany.documentoidentidad.entities.CatProfesionesEntities;
import com.mycompany.documentoidentidad.entities.CatTipoSangreEntities;
import com.mycompany.documentoidentidad.entities.DocumentoIdentidadEntities;
import com.mycompany.documentoidentidad.sessionbeanjdbc.CatDepartamentosSessionBean;
import com.mycompany.documentoidentidad.sessionbeanjdbc.CatEstadoFamiliarSessionBean;
import com.mycompany.documentoidentidad.sessionbeanjdbc.CatMunicipiosSessionBean;
import com.mycompany.documentoidentidad.sessionbeanjdbc.CatProfesionesSessionBean;
import com.mycompany.documentoidentidad.sessionbeanjdbc.CatTipoSangreSessionBean;
import com.mycompany.documentoidentidad.sessionbeanjdbc.DocumentoIdentidadSessionBean;
import com.mycompany.documentoidentidad.sessionbeanjdbc.ParametroSessionBean;
import com.mycompany.documentoidentidad.util.PropertiesConexion;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author samu5
 */
@ManagedBean(name = "documentoIdentidadController")
@ViewScoped
public class DocumentoIdentidadController {

    //VALIRABLES PARA VALIDAR SESION
    private String usuarioSession;
    private String claveSession;
    private boolean esValidaSesion;

    //VARIABLES DE GERSTION DE FORMULARIO
    private String tipodBusqueda;
    private String textoBusqueda;
    private String busquedaDepto;
    private boolean edicionUsuario;
    private boolean inabilitarCampoTexto;

    //VARIABLES PARA SUBIR IMAGEN
    private UploadedFile uploadFile;

    //VARIABLE PARA MENSAJE EN LA VISTA
    private String tituloMensajeVista;
    private String tituloPagina;
    private AnnotationConfigApplicationContext context;

    //ENTIDADES
    private DocumentoIdentidadEntities documentoEntitie;
    private CatDepartamentosEntities deptoEntitie;
    private CatMunicipiosEntities muniEntitie;
    private CatProfesionesEntities profesionEntitie;
    private CatTipoSangreEntities tipoSagreEntitie;
    private CatEstadoFamiliarEnties estadoFamEntite;

    //LISTAS DE ENTIDADES
    private List<DocumentoIdentidadEntities> listDocumentoEntitie;
    private List<CatDepartamentosEntities> listDeptoEntitie;
    private List<CatMunicipiosEntities> listMuniEntitie;
    private List<CatProfesionesEntities> listProfesionEntitie;
    private List<CatTipoSangreEntities> listTipoSagreEntitie;
    private List<CatEstadoFamiliarEnties> listEstadoFamEntite;

    //JDBC
    @Autowired
    private ParametroSessionBean paramJDBC;
    @Autowired
    private CatDepartamentosSessionBean deptoJDBC;
    @Autowired
    private CatMunicipiosSessionBean muniJDBC;
    @Autowired
    private CatEstadoFamiliarSessionBean estFamJDBC;
    @Autowired
    private CatProfesionesSessionBean profesionJDBC;
    @Autowired
    private CatTipoSangreSessionBean tipoSangreJDBC;
    @Autowired
    private DocumentoIdentidadSessionBean docuJDBC;

    @PostConstruct
    private void init() {
        this.setEsValidaSesion(false);
        this.setUsuarioSession("");
        this.setClaveSession("");
        this.setTituloMensajeVista("Ingrese credenciales, para acceder al sistema");
        this.setTituloPagina("..::Login Documentos::..");
        this.inicializarJDBC();
        this.inicializarListas();
        this.inicializarEntidades();
        this.setEdicionUsuario(false);
    }

    private void inicializarJDBC() {
        context = new AnnotationConfigApplicationContext(PropertiesConexion.class);

        paramJDBC = context.getBean(ParametroSessionBean.class);
        deptoJDBC = context.getBean(CatDepartamentosSessionBean.class);
        muniJDBC = context.getBean(CatMunicipiosSessionBean.class);
        estFamJDBC = context.getBean(CatEstadoFamiliarSessionBean.class);
        profesionJDBC = context.getBean(CatProfesionesSessionBean.class);
        tipoSangreJDBC = context.getBean(CatTipoSangreSessionBean.class);
        docuJDBC = context.getBean(DocumentoIdentidadSessionBean.class);
    }

    private void inicializarListas() {
        listDocumentoEntitie = this.getListDocumentoEntitie();
        listDeptoEntitie = this.getListDeptoEntitie();
        listMuniEntitie = this.getListMuniEntitie();
        listProfesionEntitie = this.getListProfesionEntitie();
        listTipoSagreEntitie = this.getListTipoSagreEntitie();
        listEstadoFamEntite = this.getListEstadoFamEntite();
    }

    private void inicializarEntidades() {
        documentoEntitie = new DocumentoIdentidadEntities();
        deptoEntitie = new CatDepartamentosEntities();
        muniEntitie = new CatMunicipiosEntities();
        profesionEntitie = new CatProfesionesEntities();
        tipoSagreEntitie = new CatTipoSangreEntities();
        estadoFamEntite = new CatEstadoFamiliarEnties();

        documentoEntitie.setProfesionEntitie(profesionEntitie);
        documentoEntitie.setMunicipiosEntities(muniEntitie);
        documentoEntitie.setResidenciaEntitie(muniEntitie);
        documentoEntitie.setTipoSangreEntitie(tipoSagreEntitie);
        documentoEntitie.setEstadoFamiliarEntitie(estadoFamEntite);
        documentoEntitie.setLugarNacimientoEntitie(muniEntitie);
        documentoEntitie.setLugarExpedicionEntities(muniEntitie);
    }

    //METODO PARA VALIDAR SESSION Y PODER REALIZAR ALGUNA GESTION
    public boolean validaSesion() {
        boolean bandera = false;
        if (this.getUsuarioSession().trim().isEmpty()) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar un usuario");
            this.limpiarVariablesSession();

        } else if (this.getClaveSession().trim().isEmpty()) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar una clave");
            this.limpiarVariablesSession();

        } else {
            //BUSCAMOS EL PARAMETRO DE BASE PARA VALIDAR USUARIO Y CLAVE
            String[] splitValida = paramJDBC.find("P_VALIDA_SESION").getValorParametro().split("&");

            //VALIDAMOS QUE EL USUARIO Y LA CLAVE SEAN LA CORRECTA.
            if (splitValida[0].equals(this.getUsuarioSession().trim()) && splitValida[1].equals(this.getClaveSession().trim())) {

                //SETEAMOS LAS VARIABLES PARA LA SESION ACTIVA
                this.setTituloMensajeVista("Bienvenido, puede realizar las gestiones que desee");
                this.setTituloPagina("..::Dashboard Documentos::..");
                this.setEsValidaSesion(true);

                //OCULTAMOS EL MODAL
                PrimeFaces.current().executeScript("PF('dialogValidaSesion').hide();");

                //BANDERA = TRUE, SESSION ACTIVA
                bandera = true;
                PrimeFaces.current().ajax().update("documentoForm");
            } else {
                this.mensaje(FacesMessage.SEVERITY_WARN, "Error", "Credenciales incorrectas");
            }
        }
        return bandera;
    }

    private void mensaje(FacesMessage.Severity tipo, String titulo, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, titulo, detalle));
    }

    private void limpiarVariablesSession() {
        this.setEsValidaSesion(false);
        this.setUsuarioSession("");
        this.setClaveSession("");
    }

    //AREA COLECCIONES DE DATOS, PARA MOSTRAR EN LA VISTA
    public List<DocumentoIdentidadEntities> getListDocumentoEntitie() {
        return this.listDocumentoEntitie;
    }

    public List<CatDepartamentosEntities> getListDeptoEntitie() {
        this.listDeptoEntitie = deptoJDBC.finAll();
        return this.listDeptoEntitie;
    }

    public List<CatMunicipiosEntities> getListMuniEntitie() {
        this.listMuniEntitie = muniJDBC.findAll();
        return this.listMuniEntitie;
    }

    public List<CatMunicipiosEntities> listMuniEntitieXdepto() {
        this.listMuniEntitie = muniJDBC.findDepto(this.busquedaDepto);
        return this.listMuniEntitie;
    }

    public List<CatProfesionesEntities> getListProfesionEntitie() {
        this.listProfesionEntitie = profesionJDBC.findAll();
        return this.listProfesionEntitie;
    }

    public List<CatTipoSangreEntities> getListTipoSagreEntitie() {
        this.listTipoSagreEntitie = tipoSangreJDBC.findAll();
        return this.listTipoSagreEntitie;
    }

    public List<CatEstadoFamiliarEnties> getListEstadoFamEntite() {
        this.listEstadoFamEntite = estFamJDBC.findAll();
        return listEstadoFamEntite;
    }

    //AREA BUSQUEDA Y SELECCCION DE DOCUMENTO
    public void buscarDocumento() {
        if (!this.tipodBusqueda.trim().isEmpty()) {
            switch (this.tipodBusqueda.trim()) {
                case "T":
                    this.listDocumentoEntitie = docuJDBC.findAll();
                    break;
                case "N":
                    if (!this.textoBusqueda.trim().isEmpty()) {
                        this.listDocumentoEntitie = docuJDBC.findAllName(this.textoBusqueda);
                    } else {
                        mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Rellenar el campo texto de busqueda");
                    }
                    break;
                case "D":
                    if (!this.textoBusqueda.trim().isEmpty()) {
                        this.listDocumentoEntitie = docuJDBC.findAllDocumento(this.textoBusqueda);
                    } else {
                        mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Rellenar el campo texto de busqueda");
                    }

                    break;
            }
        } else {
            mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe selecccionar un tipo de busqueda");
        }
    }

    public void guardarDocumento() {
        try {
            documentoEntitie.setEstado("A");
            documentoEntitie.setFechaExpedicion(new Date());
            documentoEntitie.setTramite("RN-1");
            boolean resp = docuJDBC.saveDocumento(documentoEntitie);
            if (resp) {
                mensaje(FacesMessage.SEVERITY_INFO, "Información", "Se ha registrado.");
                inicializarListas();
                inicializarEntidades();
                PrimeFaces.current().ajax().update("documentoForm");
            } else {
                mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "No se ha podido registrar");
            }
        } catch (Exception e) {
            mensaje(FacesMessage.SEVERITY_FATAL, "Advertencia", "No se ha podido registrar (" + e.getMessage() + ")");
        }
    }

    public void validarInabilitacionCampo(String txt) {
        switch (txt) {
            case "T":
                this.inabilitarCampoTexto = true;
                break;
            case "N":
                this.inabilitarCampoTexto = false;
                break;
            case "D":
                this.inabilitarCampoTexto = false;
                break;
            default:
                this.inabilitarCampoTexto = false;
        }
        this.textoBusqueda = "";
    }

    public void removerDocumento(String documento) {
        boolean resp = docuJDBC.deleteDocumento(documento, paramJDBC.find("P_ELIMINACION_REG").getValorParametro());
        if (resp) {
            mensaje(FacesMessage.SEVERITY_INFO, "Información", "Se a eliminado.");
        } else {
            mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "No se ha podido eliminar");
        }
    }

    public void seleccionarDocumento(DocumentoIdentidadEntities docSeleccionado) {
        if (docSeleccionado.getResidenciaEntitie() == null) {
            docSeleccionado.setResidenciaEntitie(new CatMunicipiosEntities());
        }
        this.documentoEntitie = docSeleccionado;
        this.edicionUsuario = true;
        this.textoBusqueda = "";
        PrimeFaces.current().ajax().update("documentoForm");
    }

    public void actualizarDocumento() {
        boolean resp = docuJDBC.updateDocumento(documentoEntitie);
        if (resp) {
            mensaje(FacesMessage.SEVERITY_INFO, "Información", "Se a actualizado.");
        } else {
            mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "No se ha podido actualizar");
        }
    }

    //AREA GETTER AND SETTER;
    public String getUsuarioSession() {
        return usuarioSession;
    }

    public void setUsuarioSession(String usuarioSession) {
        this.usuarioSession = usuarioSession;
    }

    public String getClaveSession() {
        return claveSession;
    }

    public void setClaveSession(String claveSession) {
        this.claveSession = claveSession;
    }

    public boolean isEsValidaSesion() {
        return esValidaSesion;
    }

    public void setEsValidaSesion(boolean esValidaSesion) {
        this.esValidaSesion = esValidaSesion;
    }

    public String getTituloMensajeVista() {
        return tituloMensajeVista;
    }

    public void setTituloMensajeVista(String tituloMensajeVista) {
        this.tituloMensajeVista = tituloMensajeVista;
    }

    public String getTituloPagina() {
        return tituloPagina;
    }

    public void setTituloPagina(String tituloPagina) {
        this.tituloPagina = tituloPagina;
    }

    public UploadedFile getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(UploadedFile uploadFile) {
        this.uploadFile = uploadFile;
    }

    public DocumentoIdentidadEntities getDocumentoEntitie() {
        return documentoEntitie;
    }

    public void setDocumentoEntitie(DocumentoIdentidadEntities documentoEntitie) {
        this.documentoEntitie = documentoEntitie;
    }

    public CatDepartamentosEntities getDeptoEntitie() {
        return deptoEntitie;
    }

    public void setDeptoEntitie(CatDepartamentosEntities deptoEntitie) {
        this.deptoEntitie = deptoEntitie;
    }

    public CatMunicipiosEntities getMuniEntitie() {
        return muniEntitie;
    }

    public void setMuniEntitie(CatMunicipiosEntities muniEntitie) {
        this.muniEntitie = muniEntitie;
    }

    public CatProfesionesEntities getProfesionEntitie() {
        return profesionEntitie;
    }

    public void setProfesionEntitie(CatProfesionesEntities profesionEntitie) {
        this.profesionEntitie = profesionEntitie;
    }

    public CatTipoSangreEntities getTipoSagreEntitie() {
        return tipoSagreEntitie;
    }

    public void setTipoSagreEntitie(CatTipoSangreEntities tipoSagreEntitie) {
        this.tipoSagreEntitie = tipoSagreEntitie;
    }

    public CatEstadoFamiliarEnties getEstadoFamEntite() {
        return estadoFamEntite;
    }

    public void setEstadoFamEntite(CatEstadoFamiliarEnties estadoFamEntite) {
        this.estadoFamEntite = estadoFamEntite;
    }

    public String getTipodBusqueda() {
        return tipodBusqueda;
    }

    public void setTipodBusqueda(String tipodBusqueda) {
        this.tipodBusqueda = tipodBusqueda;
    }

    public String getTextoBusqueda() {
        return textoBusqueda;
    }

    public void setTextoBusqueda(String textoBusqueda) {
        this.textoBusqueda = textoBusqueda;
    }

    public String getBusquedaDepto() {
        return busquedaDepto;
    }

    public void setBusquedaDepto(String busquedaDepto) {
        this.busquedaDepto = busquedaDepto;
    }

    public boolean isEdicionUsuario() {
        return edicionUsuario;
    }

    public void setEdicionUsuario(boolean edicionUsuario) {
        this.edicionUsuario = edicionUsuario;
    }

    public boolean isInabilitarCampoTexto() {
        return inabilitarCampoTexto;
    }

    public void setInabilitarCampoTexto(boolean inabilitarCampoTexto) {
        this.inabilitarCampoTexto = inabilitarCampoTexto;
    }

}
