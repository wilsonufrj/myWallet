package br.projeto.mywallet.DTO;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author wilson
 */
public class SpendDTO {
    
    private Long id;
    private Double value;
    private String description;
    private LocalDate creationDate;
    
    SpendDTO(){}

    public SpendDTO(Long id, Double value, String description, LocalDate creationDate) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
