package br.projeto.mywallet.Model;

import br.projeto.mywallet.DTO.WalletDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wallet")
public class Wallet {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    

    public Wallet(String name, String description) {
        this.name = name;
        this.description = description;
        
    }
    
    public Wallet() {
    }
    
    
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Wallet{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }
    
    public WalletDTO converteToDto(){
        return new WalletDTO(
                this.getId(),
                this.getName(),
                this.getDescription()
        );
    }
}
