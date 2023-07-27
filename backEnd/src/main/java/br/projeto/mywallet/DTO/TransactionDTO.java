package br.projeto.mywallet.DTO;

import br.projeto.mywallet.Model.Transaction;
import br.projeto.mywallet.Model.Wallet;
import br.projeto.mywallet.enums.CreditOrDebit;
import br.projeto.mywallet.enums.StatusTransaction;
import br.projeto.mywallet.enums.TypesTransaction;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author wilson
 */
@Data
@Builder
public class TransactionDTO {
    
    private Long id;
    
    private Double value;

    private String name;

    private LocalDate date;

    private String description;

    private TypesTransaction typeTransaction;
    
    public static TransactionDTO fromEntity(Transaction transaction){
        return TransactionDTO.builder()
                .id(transaction.getId())
                .value(transaction.getValue())
                .name(transaction.getName())
                .date(transaction.getDate())
                .description(transaction.getDescription())
                .typeTransaction(transaction.getTypeTransaction())
//                .statusTransaction(transaction.getStatusTransaction())
//                .creditOrDebit(transaction.getCreditOrDebit())
                .build();
    }
}
