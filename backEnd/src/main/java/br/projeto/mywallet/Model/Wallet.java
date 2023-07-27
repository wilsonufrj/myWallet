/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.projeto.mywallet.Model;

import br.projeto.mywallet.DTO.WalletDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 *
 * @author wilson
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="wallet")
public class Wallet {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    @OneToOne(cascade= CascadeType.ALL, mappedBy = "wallet")
    private HealthWallet healthWallet;

    @OneToMany(
            mappedBy = "wallet",
            targetEntity = Transaction.class,
            cascade = CascadeType.ALL
    )
    private List<Transaction> transactions;
    
    public static Wallet fromDTO(WalletDTO walletDTO){
        return Wallet.builder()
                .name(walletDTO.getName())
                .description(walletDTO.getDescription())
                .transactions(walletDTO.getTransactions())
                .build();
    } 
     
}
