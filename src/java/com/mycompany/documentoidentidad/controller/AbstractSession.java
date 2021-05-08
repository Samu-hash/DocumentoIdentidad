/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.documentoidentidad.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author samu5
 */
public abstract class AbstractSession implements Serializable {

    public void agregarValoresSession(String[] key, Object[] value, int cantidad) {
        Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        for (int i = 0; i < cantidad; i++) {
            map.put(key[i], value[i]);
        }
    }

    public boolean validarSession(String key) {
        Object obj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
        return obj != null;
    }
    
    public StreamedContent visualizarDocumento(String ruta) throws IOException{
        FacesContext fc = FacesContext.getCurrentInstance();
        
        if(fc.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE){
            return new DefaultStreamedContent();
        }else{
            return new DefaultStreamedContent(new FileInputStream(ruta), "image/png");
        }
    }
}
