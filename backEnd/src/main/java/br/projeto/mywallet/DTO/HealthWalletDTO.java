package br.projeto.mywallet.DTO;

import br.projeto.mywallet.Model.HealthWallet;
import br.projeto.mywallet.Model.Wallet;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author wilson
 */
@Data
@Builder
public class HealthWalletDTO {

    private Long id;
    private Wallet wallet;
    private Double creditLimit;
    private Double debitLimit;
    private Boolean closeMonth;
    private Double investiment;

    public static HealthWalletDTO fromEntity(HealthWallet healthWallet) {
        return HealthWalletDTO.builder()
                .id(healthWallet.getId())
                .wallet(healthWallet.getWallet())
                .creditLimit(healthWallet.getCreditLimit())
                .debitLimit(healthWallet.getDebitLimit())
                .closeMonth(healthWallet.getCloseMonth())
                .investiment(healthWallet.getInvestiment())
                .build();
    }
}
