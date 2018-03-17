package br.org.sicap.converter;

import br.org.sicap.excecoes.ClinicumLabException;
import br.org.sicap.modelo.Disciplina;
import br.org.sicap.servicos.DisciplinaServico;
import br.org.sicap.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@FacesConverter(forClass = Disciplina.class)
public class DisciplinaConverter implements Converter {

    private final DisciplinaServico disciplinaServico;

    public DisciplinaConverter() throws ClinicumLabException {
        this.disciplinaServico = CDIServiceLocator.getBean(DisciplinaServico.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Disciplina objectToReturn = null;

        if (value != null) {
            objectToReturn = this.disciplinaServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Disciplina) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }

}
