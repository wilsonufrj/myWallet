package br.projeto.mywallet.Model;

import br.projeto.mywallet.enums.TypesTransaction;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author wilson
 */
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "client")
    private Person person;
    
    @Column(name = "value")
    private Double value;
    
    @Column(name = "date")
    private LocalDate date;
    
    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="type_transaction")
    private TypesTransaction typeTransaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_wallet", referencedColumnName = "id")
    @JsonBackReference
    private Wallet wallet;

    public Transaction(Long id, Person person, Double value, LocalDate date, String description, TypesTransaction typeTransaction, Wallet wallet) {
        this.id = id;
        this.person = person;
        this.value = value;
        this.date = date;
        this.description = description;
        this.typeTransaction = typeTransaction;
        this.wallet = wallet;
    }

    public Transaction() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypesTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TypesTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    
}
