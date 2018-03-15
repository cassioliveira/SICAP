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
public class AlunoFiliacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pai", length = 100)
    private String pai;
    
    @Column(name = "formacao_pai", length = 100)
    private String formacaoPai;

    @Column(name = "mae", length = 100)
    private String mae;
    
    @Column(name = "formacao_mae", length = 100)
    private String formacaoMae;

}
