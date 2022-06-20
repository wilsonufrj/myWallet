package br.projeto.mywallet.Service;

import br.projeto.mywallet.DTO.TransactionDTO;
import java.util.List;

/**
 *
 * @author wilson
 */
public interface ITransactionService {
    
    public TransactionDTO addTransaction(TransactionDTO transactionDTO);  
    public TransactionDTO getTransaction(Long id);
    public List<TransactionDTO> getAllTransaction();
    public TransactionDTO editTransaction(Long id, TransactionDTO transactionDTO);
    public String removeTransaction(Long id);
    
}
