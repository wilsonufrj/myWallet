package br.projeto.mywallet.Model;

import br.projeto.mywallet.DTO.HealthWalletDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author wilson
 */
@Entity
@Table(name = "health")
public class HealthWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="id_wallet")
    private Wallet wallet;
    
    @Column(name="credit_limit")
    private Double creditLimit;
    
    @Column(name="debit_limit")
    private Double debitLimit;
    
    @Column(name="close_month")
    private Boolean closeMonth;
    
    @Column(name="investiment")
    private Double investiment;

    public HealthWallet(Long id, Wallet wallet, Double creditLimit, Double debitLimit, Boolean closeMonth, Double investiment) {
        this.id = id;
        this.wallet = wallet;
        this.creditLimit = creditLimit;
        this.debitLimit = debitLimit;
        this.closeMonth = closeMonth;
        this.investiment = investiment;
    }

    public HealthWallet() {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HealthWallet{");
        sb.append("id=").append(id);
        sb.append(", wallet=").append(wallet);
        sb.append(", creditLimit=").append(creditLimit);
        sb.append(", debitLimit=").append(debitLimit);
        sb.append(", closeMonth=").append(closeMonth);
        sb.append(", investiment=").append(investiment);
        sb.append('}');
        return sb.toString();
    }
    
    public HealthWalletDTO converteToDto() {
        return new HealthWalletDTO(
                this.getId(),
                this.getWallet(),
                this.getCreditLimit(),
                this.getDebitLimit(),
                this.getCloseMonth(),
                this.getInvestiment()
        );
    }
}
