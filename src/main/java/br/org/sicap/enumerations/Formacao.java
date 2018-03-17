package br.org.sicap.enumerations;

/**
 * Contains a list with Gender, represented by a letter.
 *
 * @author cassio
 */
public enum Formacao {

    FUNDAMENTAL_INCOMPLETO("Ensino fundamental incompleto"),
    FUNDAMENTAL_COMPLETO("Ensino fundamental completo "),
    MEDIO_INCOMPLETO("Ensino médio incompleto"),
    MEDIO_COMPLETO("Ensino médio completo"),
    SUPERIOR_INCOMPLETO("Curso superior incompleto"),
    SUPERIOR_COMPLETO("Curso superior completo");

    private final String descricao;

    Formacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
