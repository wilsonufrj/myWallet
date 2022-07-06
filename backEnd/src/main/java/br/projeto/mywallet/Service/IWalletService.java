package br.projeto.mywallet.Service;

import br.projeto.mywallet.DTO.TransactionDTO;
import br.projeto.mywallet.DTO.WalletDTO;
import br.projeto.mywallet.Model.Transaction;

import br.projeto.mywallet.Model.Wallet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWalletService {
    public WalletDTO createWallet(WalletDTO walletDTO);
    public List<WalletDTO> getAllWallets();
    public WalletDTO getWallet(Long id);
    public String deleteWallet(Long id);

    public WalletDTO addTransactionInWallet(Long id,TransactionDTO transactionDTO);
}
