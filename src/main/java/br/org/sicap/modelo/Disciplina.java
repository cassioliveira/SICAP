package br.org.sicap.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * Classe que representa o modelo da entidade Cliente a ser persistida no banco,
 * com todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Data
@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cadastro")
    private Date cadastro;

    @Column(name = "codigo", length = 20)
    private String codigo;

    @Column(name = "nome", nullable = false, length = 150)
    @NotNull(message = "Informe o nome da disciplina")
    private String nome;

    @Column(name = "creditos")
    private int creditos;

    @Column(name = "carga_horaria")
    private int cargaHoraria;

    @Column(name = "status", length = 100)
    private String status;
}
