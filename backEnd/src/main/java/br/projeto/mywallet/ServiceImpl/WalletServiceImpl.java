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

@Service
public class WalletServiceImpl implements IWalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public WalletDTO createWallet(WalletDTO walletDTO) {
        Wallet wallet = Wallet.fromDTO(walletDTO);
        wallet.setTransactions(new ArrayList<Transaction>());

        return WalletDTO.fromEntity(walletRepository.save(wallet));
    }

    @Override
    public WalletDTO getWallet(Long id) throws Exception {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new Exception("Wallet not found"));

        return WalletDTO.fromEntity(wallet);
    }

    @Override
    public WalletDTO updateWallet(Long id, WalletDTO walletDTO) throws Exception {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new Exception("Wallet not found"));

        wallet.setName(walletDTO.getName());
        wallet.setDescription(walletDTO.getDescription());
        wallet.setTransactions(walletDTO.getTransactions());

        return WalletDTO.fromEntity(walletRepository.save(wallet));

    }

    @Override
    public void deleteWallet(Long id) {
        walletRepository.deleteById(id);
    }

    @Override
    public List<WalletDTO> getAllWallets() {
        return walletRepository.findAll()
                .stream()
                .map(wallet -> WalletDTO.fromEntity(wallet))
                .collect(Collectors.toList());
    }

    @Override
    public WalletDTO updateNameWallet(Long id, String name) throws Exception {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new Exception("Wallet not found"));

        wallet.setName(name);

        return WalletDTO.fromEntity(walletRepository.save(wallet));

    }

    @Override
    public WalletDTO updateDescriptionWallet(Long id, String description) throws Exception {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new Exception("Wallet not found"));

        wallet.setDescription(description);

        return WalletDTO.fromEntity(walletRepository.save(wallet));

    }

}
