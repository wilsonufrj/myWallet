package br.projeto.mywallet.exception;

public class BancoJaExisteException extends RuntimeException {

    public BancoJaExisteException(String nome) {
        super("Banco já existente na base de dados: " + nome);
    }
}
