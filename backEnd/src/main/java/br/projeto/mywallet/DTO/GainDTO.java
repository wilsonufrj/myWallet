package br.projeto.mywallet.DTO;

import br.projeto.mywallet.Model.Gain;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author wilson
 */
public class GainDTO {
           
    private Long id;
    private Double value;
    private String description;
    private LocalDate creationDate;
    
    GainDTO(){}

    public GainDTO(Long id,Double value, String description, LocalDate creationDate) {
        this.value = value;
        this.description = description;
        this.creationDate = creationDate;
        this.id = id;
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
