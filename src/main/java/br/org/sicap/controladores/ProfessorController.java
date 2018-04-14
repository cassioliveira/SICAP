package br.org.sicap.controladores;

import br.org.sicap.enumerations.Formacao;
import br.org.sicap.modelo.Professor;
import br.org.sicap.servicos.ProfessorServico;
import br.org.sicap.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 * Managed bean usado pela página de cadastro de consulta. É responsável por
 * ligar a classe de modelo Consulta à página de visualização processando as
 * solicitações do usuário e retornando os dados à visualização.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Model
public class ProfessorController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Professor professor;

    @Getter
    @Setter
    @Inject
    private ProfessorServico professorServico;

    @Getter
    @Setter
    private Professor professorSelecionado;

    @Getter
    private List<Formacao> formacao;

    @Getter
    private List<Professor> professores;

    public ProfessorController() {
        professor = new Professor();
        professorSelecionado = new Professor();
    }

    @PostConstruct
    public void init() {
        this.formacao = Arrays.asList(Formacao.values());
        this.professores = professorServico.findAll();
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Professor e salvar.
     *
     */
    public void salvar() {
        professorServico.salvar(professor);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + professor.getNome()+ "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-professores.xhtml");
        professor = new Professor();
    }

    /**
     * Método responsável por excluir um objeto do tipo Professor e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.professorServico.deletar(professorSelecionado);
        this.professores = professorServico.findAll();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.professor.getId() != null;
    }

}
