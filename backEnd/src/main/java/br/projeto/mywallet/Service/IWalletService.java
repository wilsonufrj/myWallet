package br.projeto.mywallet.Service;

import br.projeto.mywallet.DTO.WalletDTO;

import java.util.List;

public interface IWalletService {
    public WalletDTO createWallet(WalletDTO walletDTO);
    public List<WalletDTO> getAllWallets();
    public WalletDTO getWallet(Long id) throws Exception;
    public WalletDTO updateWallet(Long id, WalletDTO walletDTO) throws Exception;
    public void deleteWallet(Long id);
       
   }
