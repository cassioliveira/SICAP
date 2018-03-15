package br.org.sicap.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 * Classe que representa o modelo da entidade Cliente a ser persistida no banco,
 * com todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Data
@Embeddable
public class AlunoAcademico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "classificacao", length = 100)
    private String classificacao;
    
    @Column(name = "formacao", length = 150)
    private String formacao;

}
