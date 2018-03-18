package br.org.sicap.servicos;

import br.org.sicap.repository.Professores;
import br.org.sicap.excecoes.ClinicumLabException;
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

    public ProfessorServico() {
    }

    @Transactional
    public void salvar(Professor professor) {
        if (professor.getId() == null) {
            professor.setCadastro(new Date());
        }
        this.professores.save(professor);
    }

    @Transactional
    public void deletar(Professor professor) throws ClinicumLabException {
        professores.delete(findById(professor.getId()));
    }

    public Professor findById(Long id) {
        return professores.findById(id);
    }

    public List<Professor> findAll() {
        return professores.findAll();
    }

}
