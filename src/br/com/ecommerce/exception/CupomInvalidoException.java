package br.com.ecommerce.exception;

public class CupomInvalidoException extends Exception {

    public CupomInvalidoException(String mensagem) {
        super(mensagem);
    }
}