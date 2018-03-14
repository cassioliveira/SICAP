package br.org.sicap.excecoes;

import java.io.Serializable;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class NegocioException extends RuntimeException implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public NegocioException(String message) {
        super(message);
    }
    
}
