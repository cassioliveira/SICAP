package br.org.sicap.converter;

import br.org.sicap.excecoes.SICAPException;
import br.org.sicap.modelo.Professor;
import br.org.sicap.servicos.ProfessorServico;
import br.org.sicap.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@FacesConverter(forClass = Professor.class)
public class ProfessorConverter implements Converter {

    private final ProfessorServico professorServico;

    public ProfessorConverter() throws SICAPException {
        this.professorServico = CDIServiceLocator.getBean(ProfessorServico.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Professor objectToReturn = null;

        if (value != null) {
            objectToReturn = this.professorServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Professor) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }

}
