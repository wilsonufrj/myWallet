package br.projeto.mywallet.Service;

import br.projeto.mywallet.DTO.TransactionDTO;
import br.projeto.mywallet.Model.Transaction;
import java.util.List;

/**
 *
 * @author wilson
 */
public interface ITransactionService {
    
    public TransactionDTO getTransaction(Long id) throws Exception;
    public TransactionDTO editTransaction(Long id, TransactionDTO transactionDTO) throws Exception;
    public void removeTransaction(Long id);
    public TransactionDTO addTransaction(Long id,TransactionDTO transactionDTO);
}
