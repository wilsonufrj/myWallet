package br.projeto.mywallet.ServiceImpl;


import br.projeto.mywallet.DTO.WalletDTO;
import br.projeto.mywallet.Model.Transaction;

import br.projeto.mywallet.Model.Wallet;

import br.projeto.mywallet.Service.IWalletService;
import br.projeto.mywallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.modelmapper.ModelMapper;

@Service
public class WalletServiceImpl implements IWalletService {

    @Autowired
    private WalletRepository walletRepository;
    
     @Autowired
    private ModelMapper modelMapper; 
    

    @Override
    public WalletDTO createWallet(Wallet wallet) {
        walletRepository.save(wallet);
        return this.toWalletDTO(wallet);
                 
    }

    @Override
    public WalletDTO getWallet(Long id) {
        return walletRepository.findById(id)
                .map(wallet->this.toWalletDTO(wallet))
                .get();
    }
//
//    @Override
//    public List<WalletDTO> allWallets() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String deleteWallet(Long id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public WalletDTO updateWallet(Long id, Wallet wallet) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public WalletDTO addTransaction(Long id,Transaction transaction) {
        WalletDTO auxWallet = this.getWallet(id);
        auxWallet.getTransactions().add(transaction);
        walletRepository.save(this.toWallet(auxWallet));
        return auxWallet;
    }


    private WalletDTO toWalletDTO (Wallet wallet){
        return modelMapper.map(wallet,WalletDTO.class);
    }
    
    private Wallet toWallet( WalletDTO walletDTO){
        return modelMapper.map(walletDTO, Wallet.class);
    }
   
}
