/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.projeto.mywallet.Model;

import br.projeto.mywallet.DTO.SpendDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import br.projeto.mywallet.coreInterfaces.Transaction;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author wilson
 */
@Entity
@Table(name = "spend")
public class Spend implements Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double value;
    private LocalDate creationDate;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_wallet", referencedColumnName = "id")
    @JsonBackReference
    private Wallet wallet;

    public Spend() {
    }

    @Override
    public Long getId() {
        return id;
    }
@Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public double getValue() {
        return value;
    }
@Override
    public void setValue(double value) {
        this.value = value;
    }
    
    
    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    

    @Override
    public String getDescription() {
        return description;
    }
@Override
    public void setDescription(String description) {
        this.description = description;
    }

    public static SpendDTO convertToDTO(Transaction spend) {
        return new SpendDTO(spend.getId(),
                spend.getValue(),
                spend.getDescription(),
                spend.getCreationDate());
    }

    @Override
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
