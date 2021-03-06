package br.projeto.mywallet.ServiceImpl;


import br.projeto.mywallet.DTO.TransactionDTO;
import br.projeto.mywallet.DTO.WalletDTO;
import br.projeto.mywallet.Model.Transaction;

import br.projeto.mywallet.Model.Wallet;
import br.projeto.mywallet.Service.ITransactionService;

import br.projeto.mywallet.Service.IWalletService;
import br.projeto.mywallet.repository.TransactionRepository;
import br.projeto.mywallet.repository.WalletRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

@Service
public class WalletServiceImpl implements IWalletService {

    @Autowired
    private WalletRepository walletRepository;
    
    
    @Autowired
    private ITransactionService transactionService;
    
    @Autowired
    private ModelMapper modelMapper; 
     

    @Override
    public WalletDTO createWallet(WalletDTO walletDTO) {
       return this.toWalletDTO(walletRepository.save(this.toWallet(walletDTO)));     
    }

    @Override
    public WalletDTO getWallet(Long id) {
        return walletRepository.findById(id)
                .map(wallet->this.toWalletDTO(wallet))
                .get();
    }

    @Override
    public String deleteWallet(Long id) {
        walletRepository.deleteById(id);
        return "ok";
    }


    @Override
    public WalletDTO addTransactionInWallet(Long id,TransactionDTO transactionDTO) {
        
        Wallet auxWallet = walletRepository.findById(id).get();
        Transaction auxTransaction = transactionService.toTransaction(transactionDTO);
        
        auxWallet.setAllMoney(auxWallet.getAllMoney()+auxTransaction.getValue());
        auxTransaction.setWallet(auxWallet);
        
        List<Transaction> listTransaction = auxWallet.getTransactions(); 
        listTransaction.add(auxTransaction);
        
        auxWallet.setTransactions(listTransaction);
        
        walletRepository.save(auxWallet);
        
        return this.toWalletDTO(auxWallet);
        
    }
    
    @Override
    public List<WalletDTO> getAllWallets() {
        return walletRepository.findAll()
                .stream()
                .map(wallet->this.toWalletDTO(wallet))
                .collect(Collectors.toList());
    }

    private WalletDTO toWalletDTO (Wallet wallet){
        return modelMapper.map(wallet,WalletDTO.class);
    }
    
    private Wallet toWallet( WalletDTO walletDTO){
        return modelMapper.map(walletDTO, Wallet.class);
    }

    
 
}
