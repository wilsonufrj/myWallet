package br.projeto.mywallet.DTO;


import br.projeto.mywallet.Model.Transaction;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO {

    private Long id;
    private String name;
    private Double allMoney;
    private List<Transaction> transactions = new ArrayList<Transaction>();

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

    public Double getAllMoney() {      
        return allMoney;
    }

    public void setAllMoney(Double allMoney) {
        this.allMoney = allMoney;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    
    
    
}
