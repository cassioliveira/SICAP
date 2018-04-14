package br.org.sicap.servicos;

import br.org.sicap.repository.Professores;
import br.org.sicap.modelo.Professor;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class ProfessorServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Professores professores;

    @Inject
    private PessoaServico pessoaServico;

    @Transactional
    public void salvar(Professor professor) {
        if (novoCadastro(professor)) {
            professor.setCadastro(new Date());
            professor.setMatricula(geraMatricula(professor));
            professor.setCategoria("professor");
        }
        this.professores.save(professor);
    }

    @Transactional
    public void deletar(Professor professor) {
        professores.delete(findById(professor.getId()));
    }

    public Professor findById(Long id) {
        return professores.findById(id);
    }

    public List<Professor> findAll() {
        return professores.findAll();
    }

    /**
     * Gera a matrícula do professor
     *
     * @param professor
     * @return
     */
    public String geraMatricula(Professor professor) {
        return pessoaServico.geraMatricula(Professor.class, professor.getCpf());
    }

    /**
     * Verifica se o ID do aluno já existe, indicando se é um novo cadastro.
     *
     * @param professor
     * @return
     */
    public boolean novoCadastro(Professor professor) {
        return pessoaServico.novoCadastro(professor);
    }

}
