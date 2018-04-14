package br.org.sicap.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
@Table(name = "aluno")
@EqualsAndHashCode(callSuper = false)
public class Aluno extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "matricula", length = 25)
    private String matricula;

    @CPF
    @NotNull(message = "O CPF deve ser informado")
    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "pai", length = 100)
    private String pai;

    @Column(name = "formacao_pai", length = 100)
    private String formacaoPai;

    @Column(name = "mae", length = 100)
    private String mae;

    @Column(name = "formacao_mae", length = 100)
    private String formacaoMae;

    @Column(name = "classificacao", length = 100)
    private String classificacao;

    @Column(name = "formacao", length = 150)
    private String formacao;

    @Column(name = "rua", length = 150)
    private String rua;

    @Column(name = "uf")
    private String uf;

    @Column(name = "bairro", length = 70)
    private String bairro;

    @Size(max = 7, message = "Máximo de 7 dígitos")
    @Column(name = "numero", length = 7)
    private String numero;

    @Column(name = "cidade", length = 100)
    private String cidade;

    @Column(name = "pais", length = 50)
    private String pais;

    @Column(name = "cep", length = 10)
    private String cep;

}
