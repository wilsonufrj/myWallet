package br.projeto.mywallet.exception;

public class BancoNaoEncontradoException extends RuntimeException {

    public BancoNaoEncontradoException(Long id) {
        super("Banco não encontrado com ID: " + id);
    }
}
