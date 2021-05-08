/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.documentoidentidad.controller;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author samu5
 */
@ManagedBean(name = "archivoController")
@ViewScoped
public class ArchivoController extends AbstractSession {

    public void visualizarArchivo() throws IOException {

        String ruta = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("url").toString();
        this.visualizarDocumento(ruta);
    }
}
