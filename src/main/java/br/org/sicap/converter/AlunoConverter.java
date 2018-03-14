package br.org.sicap.converter;

import br.org.sicap.excecoes.ClinicumLabException;
import br.org.sicap.modelo.Aluno;
import br.org.sicap.servicos.AlunoServico;
import br.org.sicap.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@FacesConverter(forClass = Aluno.class)
public class AlunoConverter implements Converter {

    private final AlunoServico alunoServico;

    public AlunoConverter() throws ClinicumLabException {
        this.alunoServico = CDIServiceLocator.getBean(AlunoServico.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Aluno objectToReturn = null;

        if (value != null) {
            objectToReturn = this.alunoServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Aluno) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }

}
