package br.projeto.mywallet.DTO;



import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class WalletDTO {

    private Long id;
    private String name;
    private Double allMoney;
    private Double limitCreditMonth;
    private Double limitDebitMonth;
    private List<GainDTO> gainList;
    private List<SpendDTO> spendList;
    private LocalDate creatinDate;

    public WalletDTO(Long id, String name, Double allMoney, Double limitCreditMonth, Double limitDebitMonth, List<GainDTO> gainList, List<SpendDTO> spendList, LocalDate creatinDate) {
        this.id = id;
        this.name = name;
        this.allMoney = allMoney;
        this.limitCreditMonth = limitCreditMonth;
        this.limitDebitMonth = limitDebitMonth;
        this.gainList = gainList;
        this.spendList = spendList;
        this.creatinDate = creatinDate;
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

    public LocalDate getCreatinDate() {
        return creatinDate;
    }

    public void setCreatinDate(LocalDate creatinDate) {
        this.creatinDate = creatinDate;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(Double allMoney) {
        this.allMoney = allMoney;
    }

    public List<GainDTO> getGainList() {
        return gainList;
    }

    public void setGainList(List<GainDTO> gainList) {
        this.gainList = gainList;
    }

    public List<SpendDTO> getSpendList() {
        return spendList;
    }

    public void setSpendList(List<SpendDTO> spendList) {
        this.spendList = spendList;
    }
    
    
    
    
}
