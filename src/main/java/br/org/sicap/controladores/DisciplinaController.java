package br.org.sicap.controladores;

import br.org.sicap.enumerations.Formacao;
import br.org.sicap.modelo.Disciplina;
import br.org.sicap.servicos.DisciplinaServico;
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
public class DisciplinaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Disciplina disciplina;

    @Getter
    @Setter
    @Inject
    private DisciplinaServico disciplinaServico;

    @Getter
    @Setter
    private Disciplina disciplinaSelecionada;

    @Getter
    private List<Formacao> formacao;

    @Getter
    private List<Disciplina> disciplinas;

    public DisciplinaController() {
        disciplina = new Disciplina();
        disciplinaSelecionada = new Disciplina();
    }

    @PostConstruct
    public void init() {
        this.formacao = Arrays.asList(Formacao.values());
        this.disciplinas = disciplinaServico.findAll();
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Disciplina e salvar.
     *
     */
    public void salvar() {
        disciplinaServico.salvar(disciplina);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + disciplina.getNome() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-disciplinas.xhtml");
        disciplina = new Disciplina();
    }

    /**
     * Método responsável por excluir um objeto do tipo Disciplina e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.disciplinaServico.deletar(disciplinaSelecionada);
        this.disciplinas = disciplinaServico.findAll();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.disciplina.getId() != null;
    }

}
