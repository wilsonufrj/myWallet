package br.projeto.mywallet.Service;

import br.projeto.mywallet.DTO.HomeDTO;
import br.projeto.mywallet.DTO.TransactionDTO;
import br.projeto.mywallet.DTO.WalletDTO;
import br.projeto.mywallet.Model.Transaction;

import br.projeto.mywallet.Model.Wallet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWalletService {
    HomeDTO createWallet(WalletDTO walletDTO);
    List<HomeDTO> getAllWallets();
    WalletDTO getWallet(Long id);
    void deleteWallet(Long id);

    WalletDTO addTransactionInWallet(Long id,TransactionDTO transactionDTO);
    //WalletDTO editTransactionInWallet(Long id,TransactionDTO transactionDTO);
    
}
