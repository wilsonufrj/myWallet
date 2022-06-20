package br.projeto.mywallet.DTO;

import br.projeto.mywallet.enums.StatusTransaction;
import br.projeto.mywallet.enums.TypesTransaction;
import lombok.Data;


/**
 *
 * @author wilson
 */
@Data
public class TransactionDTO {
   
    private Double value;
    private String name;
    private String day;
    private String location;
    private String description;
    private TypesTransaction typeTransaction;
    private StatusTransaction statusTransaction;
    private boolean itMonthly;
}
