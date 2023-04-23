package br.projeto.mywallet.enums;

/**
 *
 * @author wilson
 */
public enum CreditOrDebit {
    CREDIT("CREDIT"),
    DEBIT("DEBIT");

    private String creditOrDebit;

    private CreditOrDebit(String creditOrDebit) {
        this.creditOrDebit = creditOrDebit;
    }

    public String getCreditOrDebit() {
        return creditOrDebit;
    }

}
