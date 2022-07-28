package br.projeto.mywallet.Model;

import br.projeto.mywallet.enums.CreditOrDebit;
import br.projeto.mywallet.enums.StatusTransaction;
import br.projeto.mywallet.enums.TypesTransaction;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;
/**
 *
 * @author wilson
 */
@Entity
@Table(name="transaction")
@Data
@ToString
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;
    private String name;
    private String day;
 
    private String description;
    
    @Enumerated(EnumType.STRING)
    private TypesTransaction typeTransaction;
    
    @Enumerated(EnumType.STRING)
    private StatusTransaction statusTransaction;
    
    @Enumerated(EnumType.STRING)
    private CreditOrDebit creditOrDebit;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_wallet",referencedColumnName = "id")
    @JsonBackReference
    private Wallet wallet;
    
    
    
}
