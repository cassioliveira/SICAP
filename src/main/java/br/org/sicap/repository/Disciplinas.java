package br.org.sicap.repository;

import br.org.sicap.modelo.Disciplina;
import java.io.Serializable;

/**
 * Classe que contém métodos específicos que podem ser usados para fornecer
 * serviços relacionados à comunicação com o banco de dados. Essa classe, ainda,
 * herda todos os métodos abstratos da classe.
 *
 * @see DaoAbstrato
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Disciplinas extends Generic<Disciplina> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Disciplinas() {
        super(Disciplina.class);
    }
}
