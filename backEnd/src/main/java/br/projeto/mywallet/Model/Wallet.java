package br.projeto.mywallet.Model;

import br.projeto.mywallet.DTO.GainDTO;
import br.projeto.mywallet.DTO.HomeDTO;
import br.projeto.mywallet.DTO.SpendDTO;
import br.projeto.mywallet.DTO.WalletDTO;
import br.projeto.mywallet.coreInterfaces.Transaction;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author wilson
 */
@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double allMoney;
    private Double currentSpendCredit;
    private Double currentSpendDebit;
    private String name;
    private Double limitCreditMonth;
    private Double limitDebitMonth;
    private LocalDate creationDate;

    @OneToMany(
            mappedBy = "wallet",
            targetEntity = Gain.class,
            cascade = CascadeType.ALL
    )
    private List<Transaction> gainList;

    @OneToMany(
            mappedBy = "wallet",
            targetEntity = Spend.class,
            cascade = CascadeType.ALL
    )
    private List<Transaction> spendList;

    public Wallet() {

    }

    public Wallet(String name, Double limitCreditMonth, Double limitDebitMonth, LocalDate creationDate) {
        this.allMoney = 0.0;
        this.name = name;
        this.limitCreditMonth = limitCreditMonth;
        this.limitDebitMonth = limitDebitMonth;
        this.creationDate = creationDate;
    }

    public Double getAllMoney() {
        return this.allMoney;
    }

    public void setAllMoney(Double allMoney) {
        this.allMoney = allMoney;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLimitCreditMonth() {
        return limitCreditMonth;
    }

    public void setLimitCreditMonth(Double limitCreditMonth) {
        this.limitCreditMonth = limitCreditMonth;
    }

    public Double getLimitDebitMonth() {
        return limitDebitMonth;
    }

    public void setLimitDebitMonth(Double limitDebitMonth) {
        this.limitDebitMonth = limitDebitMonth;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    

    public Double getCurrentSpendCredit() {
        return currentSpendCredit;
    }

    public void setCurrentSpendCredit(Double currentSpendCredit) {
        this.currentSpendCredit = currentSpendCredit;
    }

    public Double getCurrentSpendDebit() {
        return currentSpendDebit;
    }

    public void setCurrentSpendDebit(Double currentSpendDebit) {
        this.currentSpendDebit = currentSpendDebit;
    }

    public List<Transaction> getGainList() {
        return gainList;
    }

    public void setGainList(List<Transaction> gainList) {
        this.gainList = gainList;
    }

    public List<Transaction> getSpendList() {
        return spendList;
    }

    public void setSpendList(List<Transaction> spendList) {
        this.spendList = spendList;
    }

    public static WalletDTO convertToDTO(Wallet wallet) {

        List<GainDTO> auxGainList = wallet.getGainList()
                .stream()
                .map(transaction -> Gain.convertToDTO(transaction))
                .collect(Collectors.toList());

        List<SpendDTO> auxSpendList = wallet.getSpendList()
                .stream()
                .map(transaction -> Spend.convertToDTO(transaction))
                .collect(Collectors.toList());

        return new WalletDTO(wallet.getId(),
                wallet.getName(),
                wallet.getAllMoney(),
                wallet.getLimitCreditMonth(),
                wallet.getLimitDebitMonth(),
                auxGainList,
                auxSpendList,
                wallet.getCreationDate()
        );
    }

    public static HomeDTO convertTOHomeDTO(Wallet wallet) {
        return new HomeDTO(wallet.getId(),
                wallet.getAllMoney(),
                wallet.getName(),
                wallet.getCreationDate()
        );
    }

    public static Wallet convertFromDTO(WalletDTO walletDTO) {
        return new Wallet(walletDTO.getName(),
                walletDTO.getLimitCreditMonth(),
                walletDTO.getLimitDebitMonth(),
                walletDTO.getCreatinDate());
    }

}
