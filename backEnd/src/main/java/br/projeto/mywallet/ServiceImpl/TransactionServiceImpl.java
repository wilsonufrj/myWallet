package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.TransactionDTO;
import br.projeto.mywallet.Service.ITransactionService;
import br.projeto.mywallet.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import br.projeto.mywallet.Model.Transaction;


/**
 *
 * @author wilson
 */
@Service
public class TransactionServiceImpl implements ITransactionService {
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    
    @Autowired
    private ModelMapper modelMapper; 
    

    @Override
    public TransactionDTO getTransaction(Long id) {
        return this.toTransactionDTO(transactionRepository.findById(id).get()); //Fazer um tratamento para o optional
    }


    @Override
    public TransactionDTO editTransaction(Long id, TransactionDTO transactionDTO) {
    
        Transaction auxTransaction = transactionRepository.findById(id).get();
        auxTransaction.setValue(transactionDTO.getValue());
        auxTransaction.setDay(transactionDTO.getDay());
        auxTransaction.setDescription(transactionDTO.getDescription());
        auxTransaction.setName(transactionDTO.getName());
//        auxTransaction.setStatusTransaction(transactionDTO.getStatusTransaction());
//        auxTransaction.setTypeTransaction(transactionDTO.getTypeTransaction());
        
        
        transactionRepository.save(auxTransaction);
        
        return this.toTransactionDTO(auxTransaction);
        
    }

    @Override
    public void removeTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
    
    @Override
    public Transaction toTransaction(TransactionDTO transactionDTO){
        return modelMapper.map(transactionDTO, Transaction.class);
    }
    
     @Override
    public TransactionDTO toTransactionDTO(Transaction transaction){
        return modelMapper.map(transaction, TransactionDTO.class);
    }
    
}
