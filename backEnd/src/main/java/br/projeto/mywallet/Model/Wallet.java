/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.projeto.mywallet.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;



/**
 *
 * @author wilson
 */

@Entity
@Table(name="wallet")
public class Wallet implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Double allMoney;
    private String name;

    @OneToMany(
            mappedBy = "wallet",
            targetEntity = Transaction.class,
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Transaction> transactions;

    
     public Double getAllMoney() {
        Double total = 0.0;
        
        for(Transaction transaction:this.getTransactions()){
            total+=transaction.getValue();
        }
        
        allMoney = total;
        
        return allMoney;
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
     
     
     
}
