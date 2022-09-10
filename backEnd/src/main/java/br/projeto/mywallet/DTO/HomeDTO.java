
package br.projeto.mywallet.DTO;

import java.time.LocalDate;
import java.util.Date;
import lombok.Data;


/**
 *
 * @author wilson
 */

public class HomeDTO {
    private Long id;
    private Double allMoney;
    private String name;
    private LocalDate createDate;
    
    public HomeDTO(){}
    
    public HomeDTO(Long id, Double allMoney, String name, LocalDate createDate) {
        this.id = id;
        this.allMoney = allMoney;
        this.name = name;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(Double allMoney) {
        this.allMoney = allMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    
    
    
    
    
    
}
