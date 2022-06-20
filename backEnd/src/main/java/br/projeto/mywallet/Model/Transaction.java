package br.projeto.mywallet.Model;

import br.projeto.mywallet.enums.StatusTransaction;
import br.projeto.mywallet.enums.TypesTransaction;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;
/**
 *
 * @author wilson
 */
@Entity
@Table(name="transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;
    private String name;
    private String day;
    private String location;
    private String description;
    private TypesTransaction typeTransaction;
    private StatusTransaction statusTransaction;
    private boolean itMonthly;
    
    //Acho que isso esta errado-- Rever depois
//    @ManyToOne
//    @JoinColumn(name="id_wallet")
//    private Wallet wallet;
}
