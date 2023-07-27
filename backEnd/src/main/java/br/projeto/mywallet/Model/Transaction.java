package br.projeto.mywallet.Model;

import br.projeto.mywallet.DTO.TransactionDTO;
import br.projeto.mywallet.enums.CreditOrDebit;
import br.projeto.mywallet.enums.StatusTransaction;
import br.projeto.mywallet.enums.TypesTransaction;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
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
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author wilson
 */
@Entity
@Table(name = "transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "client")
    private String client;
    @Column(name = "value")
    private Double value;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name="type_transaction")
    private TypesTransaction typeTransaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_wallet", referencedColumnName = "id")
    @JsonBackReference
    private Wallet wallet;

    public static Transaction fromDTO(TransactionDTO transactionDTO) {
        return Transaction.builder()
                .name(transactionDTO.getName())
                .value(transactionDTO.getValue())
                .date(transactionDTO.getDate())
                .description(transactionDTO.getDescription())
                .typeTransaction(transactionDTO.getTypeTransaction())
                //                .statusTransaction(transactionDTO.getStatusTransaction())
                //                .creditOrDebit(transactionDTO.getCreditOrDebit())
                .build();
    }
}
