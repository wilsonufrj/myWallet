/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.projeto.mywallet.Model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.projeto.mywallet.DTO.SpendDTO;
import lombok.Data;

/**
 *
 * @author wilson
 */

@Entity
public class Spend {
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;
    private String day;
    private String location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public SpendDTO convertDTO(){
        return new SpendDTO(this.id,
                            this.value,
                            this.day,
                            this.location,
                            this.description,
                            this.itMonthly);
    }
}
