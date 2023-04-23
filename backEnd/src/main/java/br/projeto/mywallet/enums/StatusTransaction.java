package br.projeto.mywallet.enums;

/**
 *
 * @author wilson
 */
public enum StatusTransaction {

    PAID("PAID"),
    NO_PAID("NO PAID");

    private String statusTransaction;

    private StatusTransaction(String statusTransaction) {
        this.statusTransaction = statusTransaction;
    }

    public String getStatusTransaction() {
        return statusTransaction;
    }
}
