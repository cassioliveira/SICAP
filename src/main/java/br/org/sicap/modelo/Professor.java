package br.org.sicap.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;

/**
 * Classe que representa o modelo da entidade Cliente a ser persistida no banco,
 * com todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Data
@Entity
@Table(name = "professor")
@EqualsAndHashCode(callSuper = false)
public class Professor extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "matricula", length = 25)
    private String matricula;

    @CPF
    @NotNull(message = "O CPF deve ser informado")
    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;
    
}
