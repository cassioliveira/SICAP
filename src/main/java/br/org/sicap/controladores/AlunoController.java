package br.org.sicap.controladores;

import br.org.sicap.enumerations.Formacao;
import br.org.sicap.modelo.Aluno;
import br.org.sicap.servicos.AlunoServico;
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
public class AlunoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Aluno aluno;

    @Getter
    @Setter
    @Inject
    private AlunoServico alunoServico;

    @Getter
    @Setter
    private Aluno alunoSelecionado;

    @Getter
    private List<Formacao> formacao;

    @Getter
    private List<Aluno> alunos;

    public AlunoController() {
        aluno = new Aluno();
        alunoSelecionado = new Aluno();
    }

    @PostConstruct
    public void init() {
        this.formacao = Arrays.asList(Formacao.values());
        this.alunos = alunoServico.findAll();
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Aluno e salvar.
     *
     */
    public void salvar() {
        alunoServico.salvar(aluno);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + aluno.getNome() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-alunos.xhtml");
        aluno = new Aluno();
    }

    /**
     * Método responsável por excluir um objeto do tipo Aluno e exibir ao final
     * do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.alunoServico.deletar(alunoSelecionado);
        this.alunos = alunoServico.findAll();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.aluno.getId() != null;
    }

}
