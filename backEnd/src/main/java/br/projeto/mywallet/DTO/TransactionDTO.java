package br.projeto.mywallet.DTO;

import br.projeto.mywallet.Model.Wallet;
import br.projeto.mywallet.enums.CreditOrDebit;
import br.projeto.mywallet.enums.StatusTransaction;
import br.projeto.mywallet.enums.TypesTransaction;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 *
 * @author wilson
 */
@Data
public class TransactionDTO {
    
    @JsonProperty("value")
    private Double value;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("day")
    private String day;
    
    @JsonProperty("description")
    private String description;
    
//    @JsonProperty("id_wallet")
//    private Wallet id_wallet;
//    
//    @JsonProperty("typeTransaction")
//    private TypesTransaction typeTransaction;
//    
//    @JsonProperty("statusTransaction")
//    private StatusTransaction statusTransaction;
//    
//    @JsonProperty("creditOrDebit")
//    private CreditOrDebit creditOrDebit;
}
