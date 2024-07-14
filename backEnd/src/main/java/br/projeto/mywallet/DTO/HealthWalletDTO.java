package br.projeto.mywallet.DTO;

import br.projeto.mywallet.Model.Wallet;

public class HealthWalletDTO {

    private Long id;
    private Wallet wallet;
    private Double creditLimit;
    private Double debitLimit;
    private Boolean closeMonth;
    private Double investiment;

    public HealthWalletDTO(Long id, Wallet wallet, Double creditLimit, Double debitLimit, Boolean closeMonth, Double investiment) {
        this.id = id;
        this.wallet = wallet;
        this.creditLimit = creditLimit;
        this.debitLimit = debitLimit;
        this.closeMonth = closeMonth;
        this.investiment = investiment;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Double getDebitLimit() {
        return debitLimit;
    }

    public void setDebitLimit(Double debitLimit) {
        this.debitLimit = debitLimit;
    }

    public Boolean getCloseMonth() {
        return closeMonth;
    }

    public void setCloseMonth(Boolean closeMonth) {
        this.closeMonth = closeMonth;
    }

    public Double getInvestiment() {
        return investiment;
    }

    public void setInvestiment(Double investiment) {
        this.investiment = investiment;
    }
    
    
}
