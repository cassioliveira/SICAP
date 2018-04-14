package br.org.sicap.servicos;

import br.org.sicap.repository.Alunos;
import br.org.sicap.modelo.Aluno;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class AlunoServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Alunos alunos;

    @Inject
    private PessoaServico pessoaServico;

    @Transactional
    public void salvar(Aluno aluno) {
        if (novoCadastro(aluno)) {
            aluno.setCadastro(new Date());
            aluno.setMatricula(geraMatricula(aluno));
            aluno.setCategoria("aluno");
        }
        this.alunos.save(aluno);
    }

    @Transactional
    public void deletar(Aluno aluno) {
        alunos.delete(findById(aluno.getId()));
    }

    public Aluno findById(Long id) {
        return alunos.findById(id);
    }

    public List<Aluno> findAll() {
        return alunos.findAll();
    }

    /**
     * Gera a matrícula do aluno
     *
     * @param aluno
     * @return
     */
    public String geraMatricula(Aluno aluno) {
        return pessoaServico.geraMatricula(Aluno.class, aluno.getCpf());
    }

    /**
     * Verifica se o ID do aluno já existe, indicando se é um novo cadastro.
     *
     * @param aluno
     * @return
     */
    public boolean novoCadastro(Aluno aluno) {
        return pessoaServico.novoCadastro(aluno);
    }

}
