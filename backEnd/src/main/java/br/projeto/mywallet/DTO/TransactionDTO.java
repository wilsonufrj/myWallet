package br.projeto.mywallet.DTO;

import java.time.LocalDate;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author wilson
 */
public class TransactionDTO {
    
    private String typeTransaction;
    private Double value;
    private String description;
    private LocalDate creationDate;

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    
    
    
    
}
