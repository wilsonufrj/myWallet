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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class WalletServiceImpl implements IWalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public WalletDTO createWallet(WalletDTO walletDTO) {
        Wallet wallet = new Wallet(
                walletDTO.getName(),
                walletDTO.getDescription()
        );

        try {
            return this.getWallet(walletRepository.save(wallet).getId());
        } catch (Exception ex) {
            Logger.getLogger(WalletServiceImpl.class.getName()).log(Level.SEVERE, "Error creating wallet", ex);
        }
        return null;
    }

    @Override
    public WalletDTO getWallet(Long id) throws Exception {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new Exception("Wallet not found"));

        return wallet.converteToDto();
    }

    @Override
    public WalletDTO updateWallet(Long id, WalletDTO walletDTO) throws Exception {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new Exception("Wallet not found"));

        wallet.setName(walletDTO.getName());
        wallet.setDescription(walletDTO.getDescription());

        try {
            return this.getWallet(walletRepository.save(wallet).getId());
        } catch (Exception ex) {
            Logger.getLogger("Error update wallet");
        }
        return null;
    }

    @Override
    public void deleteWallet(Long id) {
        walletRepository.deleteById(id);
    }

    @Override
    public List<WalletDTO> getAllWallets() {
        return walletRepository.findAll()
                .stream()
                .map(wallet -> wallet.converteToDto())
                .collect(Collectors.toList());
    }
}
