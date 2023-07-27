package br.projeto.mywallet.Model;

import br.projeto.mywallet.DTO.HealthWalletDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

/**
 *
 * @author wilson
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "health")
public class HealthWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="id_wallet")
    private Wallet wallet;
    
    @Column(name="credit_limit")
    private Double creditLimit;
    @Column(name="debit_limit")
    private Double debitLimit;
    @Column(name="close_month")
    private Boolean closeMonth;
    @Column(name="investiment")
    private Double investiment;
    
    public static HealthWallet toDTO(HealthWalletDTO healthWalletDTO){
        return HealthWallet.builder()
                .id(healthWalletDTO.getId())
                .wallet(healthWalletDTO.getWallet())
                .creditLimit(healthWalletDTO.getCreditLimit())
                .debitLimit(healthWalletDTO.getDebitLimit())
                .closeMonth(healthWalletDTO.getCloseMonth())
                .investiment(healthWalletDTO.getInvestiment())
                .build();
    }
}
