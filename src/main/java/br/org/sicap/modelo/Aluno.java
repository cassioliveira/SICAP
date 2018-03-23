package br.org.sicap.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
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
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cadastro")
    private Date cadastro;

    @Column(name = "matricula", length = 25)
    private String matricula;

    @Column(name = "nome", nullable = false, length = 150)
    @NotNull(message = "O nome deve ser informado")
    private String nome;

    @Column(name = "nome_social", length = 100)
    private String nomeSocial;

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Column(name = "email", length = 100)
    private String email;

    @CPF
    @Column(name = "cpf", unique = true)
    private String cpf;

    @Pattern(regexp = "^$|[a-zA-Z\\d/.-]{1,}",
            message = "Apenas letras números ou os caracteres a seguir são aceitos para o RG: / . -")
    @Column(name = "rg", length = 15)
    private String rg;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "celular", length = 20)
    private String celular;

    @Column(name = "sexo", length = 10)
    private String sexo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

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
