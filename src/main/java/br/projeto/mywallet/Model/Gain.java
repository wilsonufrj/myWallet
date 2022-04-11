package br.projeto.mywallet.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.projeto.mywallet.DTO.GainDTO;

/**
 *
 * @author wilson
 */

@Entity
@Table(name="gains")
public class Gain {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;
    private String day;
    private String description;
    private boolean itMonthly;

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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isItMonthly() {
        return itMonthly;
    }

    public void setItMonthly(boolean itMonthly) {
        this.itMonthly = itMonthly;
    }

    public GainDTO convertDTO(){
        return new GainDTO(this.id,
                            this.value,
                            this.day,
                            this.description,
                            this.itMonthly);
    }
}
