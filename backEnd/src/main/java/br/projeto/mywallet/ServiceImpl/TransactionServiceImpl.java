package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.TransactionDTO;
import br.projeto.mywallet.Service.ITransactionService;
import br.projeto.mywallet.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.projeto.mywallet.Model.Transaction;
import br.projeto.mywallet.Model.Wallet;
import br.projeto.mywallet.repository.WalletRepository;
/**
 *
 * @author wilson
 */
@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public TransactionDTO getTransaction(Long id) throws Exception {
//        Transaction auxTransaction = transactionRepository.findById(id)
//                .orElseThrow(() -> new Exception("Transaction not found"));
//
//        return TransactionDTO.fromEntity(auxTransaction);
return null;
    }

    @Override
    public TransactionDTO editTransaction(Long id, TransactionDTO transactionDTO) throws Exception {

//        Transaction auxTransaction = transactionRepository.findById(id)
//                .orElseThrow(() -> new Exception("Transaction not found"));
//
//        auxTransaction.setValue(transactionDTO.getValue());
//        auxTransaction.setDate(transactionDTO.getDate());
//        auxTransaction.setDescription(transactionDTO.getDescription());
//        auxTransaction.setName(transactionDTO.getName());
////        auxTransaction.setStatusTransaction(transactionDTO.getStatusTransaction());
////        auxTransaction.setTypeTransaction(transactionDTO.getTypeTransaction());
//
//        transactionRepository.save(auxTransaction);
//
//        return TransactionDTO.fromEntity(auxTransaction);
return null;
    }

    @Override
    public void removeTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public TransactionDTO addTransaction(Long id, TransactionDTO transactionDTO) {

//        Wallet auxWallet = walletRepository.findById(id).get();
//        Transaction auxTransaction = Transaction.fromDTO(transactionDTO);
//
//        auxTransaction.setWallet(auxWallet);
//
//        return TransactionDTO.fromEntity(transactionRepository.save(auxTransaction));
return null;
    }

}
