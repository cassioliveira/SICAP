package br.org.sicap.servicos;

import br.org.sicap.repository.Alunos;
import br.org.sicap.excecoes.ClinicumLabException;
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

    public AlunoServico() {
    }

    @Transactional
    public void salvar(Aluno aluno) {
        if (aluno.getId() == null) {
            aluno.setCadastro(new Date());
        }
        this.alunos.save(aluno);
    }

    @Transactional
    public void deletar(Aluno aluno) throws ClinicumLabException {
        alunos.delete(findById(aluno.getId()));
    }

    public Aluno findById(Long id) {
        return alunos.findById(id);
    }

    public List<Aluno> findAll() {
        return alunos.findAll();
    }

}
