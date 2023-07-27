package br.projeto.mywallet.Service;

import br.projeto.mywallet.DTO.TransactionDTO;
import br.projeto.mywallet.DTO.WalletDTO;
import br.projeto.mywallet.Model.Transaction;

import br.projeto.mywallet.Model.Wallet;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IWalletService {
    public WalletDTO createWallet(WalletDTO walletDTO);
    public List<WalletDTO> getAllWallets();
    public WalletDTO getWallet(Long id) throws Exception;
    public WalletDTO updateWallet(Long id, WalletDTO walletDTO) throws Exception;
    public void deleteWallet(Long id);
    
    public WalletDTO updateNameWallet(Long id,String name) throws Exception;
    public WalletDTO updateDescriptionWallet(Long id, String description) throws Exception;
}
