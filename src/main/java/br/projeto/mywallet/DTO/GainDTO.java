package br.projeto.mywallet.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor

public class GainDTO {

    private Long id;
    private Double value;
    private String day;
    private String description;
    private boolean itMonthly;

    public Long getId(){
        return id;
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
}
