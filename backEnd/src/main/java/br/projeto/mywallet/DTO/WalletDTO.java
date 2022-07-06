package br.projeto.mywallet.DTO;


import br.projeto.mywallet.Model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WalletDTO {

    private Long id;
    private String name;
    private Double allMoney;
    private List<Transaction> transactions;
    
}
