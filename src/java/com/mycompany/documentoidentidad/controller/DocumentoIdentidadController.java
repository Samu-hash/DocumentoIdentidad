package com.mycompany.documentoidentidad.controller;

import com.mycompany.documentoidentidad.entities.CatDepartamentosEntities;
import com.mycompany.documentoidentidad.entities.CatEstadoFamiliarEnties;
import com.mycompany.documentoidentidad.entities.CatMunicipiosEntities;
import com.mycompany.documentoidentidad.entities.CatProfesionesEntities;
import com.mycompany.documentoidentidad.entities.CatTipoSangreEntities;
import com.mycompany.documentoidentidad.entities.DocumentoIdentidadEntities;
import com.mycompany.documentoidentidad.entities.DocumentoIdentidadEntitiesReport;
import com.mycompany.documentoidentidad.sessionbeanjdbc.CatDepartamentosSessionBean;
import com.mycompany.documentoidentidad.sessionbeanjdbc.CatEstadoFamiliarSessionBean;
import com.mycompany.documentoidentidad.sessionbeanjdbc.CatMunicipiosSessionBean;
import com.mycompany.documentoidentidad.sessionbeanjdbc.CatProfesionesSessionBean;
import com.mycompany.documentoidentidad.sessionbeanjdbc.CatTipoSangreSessionBean;
import com.mycompany.documentoidentidad.sessionbeanjdbc.DocumentoIdentidadSessionBean;
import com.mycompany.documentoidentidad.sessionbeanjdbc.ParametroSessionBean;
import com.mycompany.documentoidentidad.util.PropertiesConexion;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author samu5
 */
@ManagedBean(name = "documentoIdentidadController")
@ViewScoped
public class DocumentoIdentidadController extends AbstractSession implements Serializable {

    //VALIRABLES PARA VALIDAR SESION
    private String usuarioSession;
    private String claveSession;
    private boolean esValidaSesion;

    //VARIBALES PARA VALIDACION DE FORMULARIO
    private Date fechaMinima;
    private Date fechaNow;

    //VARIABLES DE GERSTION DE FORMULARIO
    private String tipodBusqueda;
    private String textoBusqueda;
    private boolean edicionUsuario;
    private boolean inabilitarCampoTexto;
    private String nombreImagen;

    //VARIABLES PARA SUBIR IMAGEN
    private UploadedFile uploadFile;
    private InputStream iStream;

    //VARIABLE PARA MENSAJE EN LA VISTA
    private String tituloMensajeVista;
    private String tituloPagina;
    private AnnotationConfigApplicationContext context;

    //ENTIDADES
    //-------------------
    private DocumentoIdentidadEntities documentoEntitie;
    private CatProfesionesEntities profesionEntitie;
    private CatTipoSangreEntities tipoSagreEntitie;
    private CatEstadoFamiliarEnties estadoFamEntite;
    //---------------Nacimiento
    private CatDepartamentosEntities deptoNacEntitie;
    private CatMunicipiosEntities muniNacEntitie;
    //--------------Residencia
    private CatDepartamentosEntities depoResEntitie;
    private CatMunicipiosEntities muniResEntitie;
    //--------------Expedicion
    private CatDepartamentosEntities depoExpEntitie;
    private CatMunicipiosEntities muniExpEntitie;

    //LISTAS DE ENTIDADES
    //-------------------
    private List<DocumentoIdentidadEntities> listDocumentoEntitie;
    private List<CatProfesionesEntities> listProfesionEntitie;
    private List<CatTipoSangreEntities> listTipoSagreEntitie;
    private List<CatEstadoFamiliarEnties> listEstadoFamEntite;
    //--------------Nacimiento
    private List<CatDepartamentosEntities> listDeptoNacEntitie;
    private List<CatMunicipiosEntities> listMuniNacEntitie;
    //--------------Residencia
    private List<CatDepartamentosEntities> listDepoResEntitie;
    private List<CatMunicipiosEntities> listMuniResEntitie;
    //--------------Expedicion
    private List<CatDepartamentosEntities> listDepoExpEntitie;
    private List<CatMunicipiosEntities> listMuniExpEntitie;

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
        this.controlfechaMinima();
        
    }
    
    private void controlfechaMinima() {
        this.fechaMinima = new Date();
        Calendar calendar = Calendar.getInstance();
        
        calendar.setTime(this.fechaMinima);

        //Calculamos 18 años atras para que se valide la fecha
        calendar.add(Calendar.YEAR, -18);
        
        this.fechaMinima = calendar.getTime();
        this.fechaNow = new Date();
        this.documentoEntitie.setFechaNacimiento(this.fechaMinima);
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
        listProfesionEntitie = this.getListProfesionEntitie();
        listTipoSagreEntitie = this.getListTipoSagreEntitie();
        listEstadoFamEntite = this.getListEstadoFamEntite();
        //--------------Nacimiento
        listDeptoNacEntitie = this.getListDeptoNacEntitie();
        listMuniNacEntitie = this.getListMuniNacEntitie();
        //--------------Residencia
        listDepoResEntitie = this.getListDepoResEntitie();
        listMuniResEntitie = this.getListMuniResEntitie();
        //--------------Expedicion
        listDepoExpEntitie = this.getListDepoExpEntitie();
        listMuniExpEntitie = this.getListMuniExpEntitie();
    }
    
    private void inicializarEntidades() {
        documentoEntitie = new DocumentoIdentidadEntities();
        //-------------DOCUMENTO
        documentoEntitie.setProfesionEntitie(new CatProfesionesEntities());
        documentoEntitie.setTipoSangreEntitie(new CatTipoSangreEntities());
        documentoEntitie.setEstadoFamiliarEntitie(new CatEstadoFamiliarEnties());
        documentoEntitie.setMunicipiosEntities(new CatMunicipiosEntities());
        documentoEntitie.setLugarExpedicionEntities(new CatMunicipiosEntities());
        documentoEntitie.setLugarNacimientoEntitie(new CatMunicipiosEntities());
        
        profesionEntitie = new CatProfesionesEntities();
        tipoSagreEntitie = new CatTipoSangreEntities();
        estadoFamEntite = new CatEstadoFamiliarEnties();
        //---------------Nacimiento
        deptoNacEntitie = new CatDepartamentosEntities();
        muniNacEntitie = new CatMunicipiosEntities();
        //--------------Residencia
        depoResEntitie = new CatDepartamentosEntities();
        muniResEntitie = new CatMunicipiosEntities();
        //--------------Expedicion
        depoExpEntitie = new CatDepartamentosEntities();
        muniExpEntitie = new CatMunicipiosEntities();
        
    }
    
    public void validarSesionActiva() {
        this.esValidaSesion = this.validarSession("session");
    }
    
    public boolean validarFormulario() {
        if (this.documentoEntitie.getIdDocumento() == null || this.documentoEntitie.getIdDocumento().isEmpty()) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar un documento");
            return false;
        } else if (this.documentoEntitie.getNombres() == null || this.documentoEntitie.getApellidos().isEmpty()) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar un nombre");
            return false;
        } else if (this.documentoEntitie.getGenero() == null || this.documentoEntitie.getGenero().isEmpty()) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar un apellido");
            return false;
        } else if (this.documentoEntitie.getResidencia() == null || this.documentoEntitie.getResidencia().isEmpty()) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar una residencia");
            return false;
        } else if (this.documentoEntitie.getCodidoZona() == null || this.documentoEntitie.getCodidoZona().isEmpty()) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar un codigo de zona");
            return false;
        } else if (this.getDeptoNacEntitie() == null) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar un departamento de nacimiento");
            return false;
        } else if (this.getMuniNacEntitie() == null || this.getMuniNacEntitie().getIdMunicipio() == 0) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar un municipio de nacimiento");
            return false;
        } else if (this.getProfesionEntitie() == null || this.getProfesionEntitie().getIdProfesiones() == 0) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar una profesión");
            return false;
        } else if (this.getDepoExpEntitie() == null || this.getDepoExpEntitie().getIdDepartamento() == 0) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar un departamento de expedición");
            return false;
        } else if (this.getMuniExpEntitie() == null || this.getMuniExpEntitie().getIdMunicipio() == 0) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar un municipio de expedición");
            return false;
        } else if (this.getDepoResEntitie() == null || this.getDepoResEntitie().getIdDepartamento() == 0) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar un departamento de residencia");
            return false;
        } else if (this.getMuniResEntitie() == null || this.getMuniResEntitie().getIdMunicipio() == 0) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar un municipio de residencia");
            return false;
        } else if (this.getEstadoFamEntite() == null || this.getEstadoFamEntite().getIdEstadoFamiliar() == 0) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar un estado familiar");
            return false;
        } else if (this.getTipoSagreEntitie() == null || this.getTipoSagreEntitie().getIdTipoSangre() == 0) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar un tipo de sangre");
            return false;
        } else {
            int valor = docuJDBC.existenciaDocumento(this.documentoEntitie.getIdDocumento());
            if (valor == 1) {
                this.mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "El documento ya existe, por favor ingrese otro documento");
                return false;
            }
            return true;
        }
    }

    //METODO PARA VALIDAR SESSION Y PODER REALIZAR ALGUNA GESTION
    public boolean validaSesion() {
        boolean bandera = false;
        try {
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
                    
                    String[] key = new String[2];
                    Object[] value = new Object[2];
                    key[0] = "session";
                    value[0] = splitValida[0];
                    this.agregarValoresSession(key, value, 1);

                    //OCULTAMOS EL MODAL
                    PrimeFaces.current().executeScript("PF('dialogValidaSesion').hide();");

                    //BANDERA = TRUE, SESSION ACTIVA
                    bandera = true;
                    PrimeFaces.current().ajax().update("documentoForm");
                } else {
                    this.mensaje(FacesMessage.SEVERITY_WARN, "Error", "Credenciales incorrectas");
                }
            }
        } catch (Exception e) {
            this.mensaje(FacesMessage.SEVERITY_WARN, "Error", "Objecto (" + e + ") Mensaje(" + e.getMessage() + ")");
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
            if (this.validarFormulario()) {
                documentoEntitie.setEstado("A");
                documentoEntitie.setFechaExpedicion(new Date());
                documentoEntitie.setTramite("RN-1");
                documentoEntitie.setResidenciaEntitie(this.getMuniResEntitie());
                documentoEntitie.setLugarNacimientoEntitie(this.getMuniNacEntitie());
                documentoEntitie.setLugarExpedicionEntities(this.getMuniExpEntitie());
                documentoEntitie.setResidenciaEntitie(this.getMuniResEntitie());
                documentoEntitie.setEstadoFamiliarEntitie(this.getEstadoFamEntite());
                documentoEntitie.setTipoSangreEntitie(this.getTipoSagreEntitie());
                documentoEntitie.setProfesionEntitie(this.getProfesionEntitie());
                
                String relativePath = "resources/imgDocu/";
                String nombreArchivo = this.uploadFile.getFileName();
                
                nombreArchivo = nombreArchivo.replace(this.uploadFile.getFileName(),
                        documentoEntitie.getIdDocumento()) + "."
                        + this.getFileExtension(this.uploadFile.getFileName());
                
                documentoEntitie.setUrlFoto(relativePath + nombreArchivo);
                try {
                    this.guardarImagen(nombreArchivo, this.iStream);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                boolean resp = docuJDBC.saveDocumento(documentoEntitie);
                if (resp) {
                    mensaje(FacesMessage.SEVERITY_INFO, "Información", "Se ha registrado. ");
                    inicializarEntidades();
                    PrimeFaces.current().ajax().update("documentoForm");
                } else {
                    mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "No se ha podido registrar");
                }
            } else {
                PrimeFaces.current().ajax().update("documentoForm");
            }
            
        } catch (Exception e) {
            mensaje(FacesMessage.SEVERITY_FATAL, "Advertencia", "No se ha podido registrar (" + e.getMessage() + ")");
        }
    }
    
    private boolean guardarImagen(String fileName, InputStream in) {
        try {
            String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/imgDocu/");
            OutputStream out = new FileOutputStream(new File(path + fileName));
            
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
        PrimeFaces.current().ajax().update("documentoForm");
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

    //ACTUALIZACION DE DOCUMENTO
    public void actualizarDocumento() {
        boolean resp = docuJDBC.updateDocumento(documentoEntitie);
        if (resp) {
            mensaje(FacesMessage.SEVERITY_INFO, "Información", "Se a actualizado.");
        } else {
            mensaje(FacesMessage.SEVERITY_WARN, "Advertencia", "No se ha podido actualizar");
        }
        PrimeFaces.current().ajax().update("documentoForm");
    }
    
    private String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "jpg";
        }
    }
    
    public void handleFileUpload(FileUploadEvent event) throws IOException {
        this.uploadFile = event.getFile();
        this.iStream = uploadFile.getInputStream();
    }

    //AREAS PARA VISUALIZAR PDF
    public void visualizarPDF(String documento) throws Exception {
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext()
                .getRealPath("/resources/reports/reporteDocumentoIdentidad.jasper"));
        
        List<DocumentoIdentidadEntitiesReport> lista = docuJDBC.findAllDocumentoReport(documento);
        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRBeanCollectionDataSource(lista));
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance()
                .getExternalContext().getResponse();
        
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream out = response.getOutputStream();
        out.write(bytes, 0, bytes.length);
        out.flush();
        out.close();
        FacesContext.getCurrentInstance().responseComplete();
        
    }

    //-----MÉTODO PARA CARGAR ARCHIVO A VISUALIZAR
    public void cargarArchivo(String urlArchivo) {
        try {
            if (urlArchivo != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ruta", urlArchivo);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
    
    public String getNombreImagen() {
        return nombreImagen;
    }
    
    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }
    
    public InputStream getiStream() {
        return iStream;
    }
    
    public void setiStream(InputStream iStream) {
        this.iStream = iStream;
    }

    //-----------ENTIDADES
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
    
    public CatDepartamentosEntities getDeptoNacEntitie() {
        return deptoNacEntitie;
    }
    
    public void setDeptoNacEntitie(CatDepartamentosEntities deptoNacEntitie) {
        this.deptoNacEntitie = deptoNacEntitie;
    }
    
    public CatMunicipiosEntities getMuniNacEntitie() {
        return muniNacEntitie;
    }
    
    public void setMuniNacEntitie(CatMunicipiosEntities muniNacEntitie) {
        this.muniNacEntitie = muniNacEntitie;
    }
    
    public CatDepartamentosEntities getDepoResEntitie() {
        return depoResEntitie;
    }
    
    public void setDepoResEntitie(CatDepartamentosEntities depoResEntitie) {
        this.depoResEntitie = depoResEntitie;
    }
    
    public CatMunicipiosEntities getMuniResEntitie() {
        return muniResEntitie;
    }
    
    public void setMuniResEntitie(CatMunicipiosEntities muniResEntitie) {
        this.muniResEntitie = muniResEntitie;
    }
    
    public CatDepartamentosEntities getDepoExpEntitie() {
        return depoExpEntitie;
    }
    
    public void setDepoExpEntitie(CatDepartamentosEntities depoExpEntitie) {
        this.depoExpEntitie = depoExpEntitie;
    }
    
    public CatMunicipiosEntities getMuniExpEntitie() {
        return muniExpEntitie;
    }
    
    public void setMuniExpEntitie(CatMunicipiosEntities muniExpEntitie) {
        this.muniExpEntitie = muniExpEntitie;
    }

    //---------------LISTAS
    public List<CatProfesionesEntities> getListProfesionEntitie() {
        listProfesionEntitie = profesionJDBC.findAll();
        return listProfesionEntitie;
    }
    
    public void setListProfesionEntitie(List<CatProfesionesEntities> listProfesionEntitie) {
        this.listProfesionEntitie = listProfesionEntitie;
    }
    
    public List<CatTipoSangreEntities> getListTipoSagreEntitie() {
        listTipoSagreEntitie = tipoSangreJDBC.findAll();
        return listTipoSagreEntitie;
    }
    
    public void setListTipoSagreEntitie(List<CatTipoSangreEntities> listTipoSagreEntitie) {
        this.listTipoSagreEntitie = listTipoSagreEntitie;
    }
    
    public List<CatEstadoFamiliarEnties> getListEstadoFamEntite() {
        listEstadoFamEntite = estFamJDBC.findAll();
        return listEstadoFamEntite;
    }
    
    public void setListEstadoFamEntite(List<CatEstadoFamiliarEnties> listEstadoFamEntite) {
        this.listEstadoFamEntite = listEstadoFamEntite;
    }
    
    public List<CatDepartamentosEntities> getListDeptoNacEntitie() {
        listDeptoNacEntitie = deptoJDBC.finAll();
        return listDeptoNacEntitie;
    }
    
    public void setListDeptoNacEntitie(List<CatDepartamentosEntities> listDeptoNacEntitie) {
        this.listDeptoNacEntitie = listDeptoNacEntitie;
    }
    
    public List<CatMunicipiosEntities> getListMuniNacEntitie() {
        listMuniNacEntitie = muniJDBC.findAll();
        return listMuniNacEntitie;
    }
    
    public List<CatMunicipiosEntities> getListMuniNacDepto() {
        listMuniNacEntitie = muniJDBC.findDepto(this.deptoNacEntitie);
        return listMuniNacEntitie;
    }
    
    public void setListMuniNacEntitie(List<CatMunicipiosEntities> listMuniNacEntitie) {
        this.listMuniNacEntitie = listMuniNacEntitie;
    }
    
    public List<CatDepartamentosEntities> getListDepoResEntitie() {
        listDepoResEntitie = deptoJDBC.finAll();
        return listDepoResEntitie;
    }
    
    public void setListDepoResEntitie(List<CatDepartamentosEntities> listDepoResEntitie) {
        this.listDepoResEntitie = listDepoResEntitie;
    }
    
    public List<CatMunicipiosEntities> getListMuniResEntitie() {
        listMuniResEntitie = muniJDBC.findAll();
        return listMuniResEntitie;
    }
    
    public List<CatMunicipiosEntities> getListMuniResDepto() {
        listMuniResEntitie = muniJDBC.findDepto(this.depoResEntitie);
        return listMuniResEntitie;
    }
    
    public void setListMuniResEntitie(List<CatMunicipiosEntities> listMuniResEntitie) {
        this.listMuniResEntitie = listMuniResEntitie;
    }
    
    public List<CatDepartamentosEntities> getListDepoExpEntitie() {
        listDepoExpEntitie = deptoJDBC.finAll();
        return listDepoExpEntitie;
    }
    
    public void setListDepoExpEntitie(List<CatDepartamentosEntities> listDepoExpEntitie) {
        this.listDepoExpEntitie = listDepoExpEntitie;
    }
    
    public List<CatMunicipiosEntities> getListMuniExpEntitie() {
        listMuniExpEntitie = muniJDBC.findAll();
        return listMuniExpEntitie;
    }
    
    public List<CatMunicipiosEntities> getListMuniExpDepto() {
        listMuniExpEntitie = muniJDBC.findDepto(this.depoExpEntitie);
        return listMuniExpEntitie;
    }
    
    public void setListMuniExpEntitie(List<CatMunicipiosEntities> listMuniExpEntitie) {
        this.listMuniExpEntitie = listMuniExpEntitie;
    }
    
    public Date getFechaMinima() {
        return fechaMinima;
    }
    
    public void setFechaMinima(Date fechaMinima) {
        this.fechaMinima = fechaMinima;
    }
    
    public Date getFechaNow() {
        return fechaNow;
    }
    
    public void setFechaNow(Date fechaNow) {
        this.fechaNow = fechaNow;
    }
    
}
