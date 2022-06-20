package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.TransactionDTO;
import br.projeto.mywallet.Service.ITransactionService;
import br.projeto.mywallet.repository.TransactionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import br.projeto.mywallet.Model.Transaction;
import br.projeto.mywallet.enums.StatusTransaction;
import br.projeto.mywallet.enums.TypesTransaction;
import java.util.stream.Collectors;

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
    public TransactionDTO addTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = this.toTransaction(transactionDTO);
         transactionRepository.save(transaction);
        return transactionDTO;
    }

    @Override
    public TransactionDTO getTransaction(Long id) {
        return this.toTransactionDTO(transactionRepository.findById(id).get()); //Fazer um tratamento para o optional
    }

    @Override
    public List<TransactionDTO> getAllTransaction() {
        return transactionRepository.findAll()
                .stream()
                .map(transaction->this.toTransactionDTO(transaction))
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDTO editTransaction(Long id, TransactionDTO transactionDTO) {
    
        Transaction auxTransaction = transactionRepository.findById(id).get();
        auxTransaction.setValue(transactionDTO.getValue());
        auxTransaction.setDay(transactionDTO.getDay());
        auxTransaction.setDescription(transactionDTO.getDescription());
        auxTransaction.setLocation(transactionDTO.getLocation());
        auxTransaction.setName(transactionDTO.getName());
        auxTransaction.setStatusTransaction(transactionDTO.getStatusTransaction());
        auxTransaction.setTypeTransaction(transactionDTO.getTypeTransaction());
        auxTransaction.setItMonthly(transactionDTO.isItMonthly());
        
        
        transactionRepository.save(auxTransaction);
        
        return this.toTransactionDTO(auxTransaction);
        
    }

    @Override
    public String removeTransaction(Long id) {
        transactionRepository.deleteById(id);
        return "Transaction Deleted";
    }
    
    private Transaction toTransaction(TransactionDTO transactionDTO){
        return modelMapper.map(transactionDTO, Transaction.class);
    }
    
    private TransactionDTO toTransactionDTO(Transaction transaction){
        return modelMapper.map(transaction, TransactionDTO.class);
    }
    
}
