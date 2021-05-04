/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.documentoidentidad.util;

import com.mycompany.documentoidentidad.entities.CatProfesionesEntities;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author samu5
 */
@FacesConverter( value = "profesionConverter")
public class ProfesionConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
        ValueExpression vex = ctx.getApplication().getExpressionFactory()
                .createValueExpression(ctx.getELContext(),
                        "#{CatProfesionesEntities}", CatProfesionesEntities.class);

        CatProfesionesEntities beers = (CatProfesionesEntities) vex.getValue(ctx.getELContext());
        return beers.getIdProfesiones();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object beer) {
        return String.valueOf(((CatProfesionesEntities) beer).getIdProfesiones());
    }

}
