package br.org.sicap.servicos;

import br.org.sicap.repository.Disciplinas;
import br.org.sicap.modelo.Disciplina;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class DisciplinaServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Disciplinas disciplinas;

    @Transactional
    public void salvar(Disciplina disciplina) {
        if (disciplina.getId() == null) {
            disciplina.setCadastro(new Date());
        }
        this.disciplinas.save(disciplina);
    }

    @Transactional
    public void deletar(Disciplina disciplina) {
        disciplinas.delete(findById(disciplina.getId()));
    }

    public Disciplina findById(Long id) {
        return disciplinas.findById(id);
    }

    public List<Disciplina> findAll() {
        return disciplinas.findAll();
    }

}
