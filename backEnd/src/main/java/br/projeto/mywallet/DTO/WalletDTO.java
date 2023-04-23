package br.projeto.mywallet.DTO;


import br.projeto.mywallet.Model.Transaction;
import br.projeto.mywallet.Model.Wallet;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalletDTO {

    private Long id;
    private String name;
    private String description;
    private List<Transaction> transactions;
    
    public static WalletDTO fromEntity(Wallet wallet){
        return WalletDTO.builder()
                .id(wallet.getId())
                .name(wallet.getName())
                .description(wallet.getDescription())
                .transactions(wallet.getTransactions())
                .build();
    }
    
}
