package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.HomeDTO;
import br.projeto.mywallet.DTO.TransactionDTO;
import br.projeto.mywallet.DTO.WalletDTO;
import br.projeto.mywallet.Model.Gain;

import br.projeto.mywallet.Model.Wallet;

import br.projeto.mywallet.Service.IWalletService;
import br.projeto.mywallet.coreInterfaces.Transaction;
import br.projeto.mywallet.factory.TransactionFactory;
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
    public HomeDTO createWallet(WalletDTO walletDTO) {
        return Wallet.convertTOHomeDTO(walletRepository.save(Wallet.convertFromDTO(walletDTO)));

    }

    @Override
    public WalletDTO getWallet(Long id) {
        return walletRepository.findById(id)
                .map(wallet -> wallet.convertToDTO(wallet))
                .get();
    }

    @Override
    public void deleteWallet(Long id) {
        walletRepository.deleteById(id);
    }

    @Override
    public WalletDTO addTransaction(Long id, TransactionDTO transactionDTO) {

        Wallet wallet = walletRepository.findById(id).get();
        Transaction transaction = TransactionFactory
                .transaction(transactionDTO.getTypeTransaction());
        
        
        transaction.setWallet(wallet);
        transaction.setValue(transactionDTO.getValue());
        transaction.setDescription(transactionDTO.getDescription());
        transaction.setCreationDate(transactionDTO.getCreationDate());
      
        if (transaction.getClass().equals(Gain.class)) {
            wallet.getGainList().add(transaction);
            wallet.setAllMoney(wallet.getAllMoney() + transaction.getValue());
        } else {
            wallet.getSpendList().add(transaction);
            wallet.setAllMoney(wallet.getAllMoney() - transaction.getValue());
        }

        return Wallet.convertToDTO(walletRepository.save(wallet));

    }

    @Override
    public List<HomeDTO> getAllWallets() {
        return walletRepository.findAll()
                .stream()
                .map(wallet -> Wallet.convertTOHomeDTO(wallet))
                .collect(Collectors.toList());
    }

}
