package br.org.sicap.servicos;

import br.org.sicap.modelo.Pessoa;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Possui metodos comuns a todas as entidades que herdam de <b>Pessoa</b>
 * @see Pessoa
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class PessoaServico implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Verifica se o ID da pessoa já existe, indicando se é um novo cadastro. 
     * 
     * @param entidade
     * @return 
     */
    public boolean novoCadastro(Pessoa entidade){
        return entidade.getId() == null;
    }

    /**
     * Recebe a entidade e o campo a ser inserido na geração de matrícula
     *
     * @param entidade
     * @param campo
     * @return
     */
    public String geraMatricula(Class entidade, String campo) {
        String matricula;
        LocalDate agora = LocalDate.now();
        int ano = agora.getYear();
        String cpf = campo.replaceAll("\\.", "").replaceAll("\\-", "");
        matricula = ano + cpf;

        return matricula;
    }

}
