package br.projeto.mywallet.Service;

import br.projeto.mywallet.DTO.TransactionDTO;
import br.projeto.mywallet.Model.Transaction;
import java.util.List;

/**
 *
 * @author wilson
 */
public interface ITransactionService {
    
    public TransactionDTO getTransaction(Long id);
    public TransactionDTO editTransaction(Long id, TransactionDTO transactionDTO);
    public String removeTransaction(Long id);
    
    
    public Transaction toTransaction(TransactionDTO transactionDTO);
    public TransactionDTO toTransactionDTO(Transaction transaction);
    
}
