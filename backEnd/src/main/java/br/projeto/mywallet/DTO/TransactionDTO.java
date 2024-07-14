package br.projeto.mywallet.DTO;

import br.projeto.mywallet.Model.Person;
import br.projeto.mywallet.enums.TypesTransaction;
import java.time.LocalDate;

public class TransactionDTO {

    private Long id;

    private Person person;

    private Double value;

    private LocalDate date;

    private String description;

    private TypesTransaction typeTransaction;

    private WalletDTO wallet;

    public TransactionDTO(Long id, Person person, Double value, LocalDate date, String description, TypesTransaction typeTransaction, WalletDTO wallet) {
        this.id = id;
        this.person = person;
        this.value = value;
        this.date = date;
        this.description = description;
        this.typeTransaction = typeTransaction;
        this.wallet = wallet;
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

    public WalletDTO getWallet() {
        return wallet;
    }

    public void setWallet(WalletDTO wallet) {
        this.wallet = wallet;
    }

}
