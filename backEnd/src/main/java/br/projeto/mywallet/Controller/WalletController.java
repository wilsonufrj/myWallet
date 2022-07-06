/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.projeto.mywallet.Controller;


import br.projeto.mywallet.DTO.TransactionDTO;
import br.projeto.mywallet.DTO.WalletDTO;
import br.projeto.mywallet.Model.Transaction;
import br.projeto.mywallet.Model.Wallet;
import br.projeto.mywallet.Service.IWalletService;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wilson
 */
@RestController
@RequestMapping("/wallet")
@CrossOrigin
public class WalletController {
    
    @Autowired
    private IWalletService walletService;

    @GetMapping(path="/{id}")
    public ResponseEntity getWallet(@PathVariable Long id){
        return ResponseEntity.ok(walletService.getWallet(id));
    }
    
    @GetMapping
    public ResponseEntity getAllWallets(){
        return ResponseEntity.ok(walletService.getAllWallets());
    }
    
    @PostMapping
    public ResponseEntity createWallet(@RequestBody WalletDTO walletDTO){
        return ResponseEntity.ok(walletService.createWallet(walletDTO));
    }
    
    @PostMapping(path="/transaction/{id}")
    public ResponseEntity addTransaction(@PathVariable Long id,@RequestBody TransactionDTO transactionDTO){
        return ResponseEntity.ok(walletService.addTransactionInWallet(id,transactionDTO));
    }
    
    @DeleteMapping
    public ResponseEntity deleteWallet(@PathVariable Long id){
        return ResponseEntity.ok(walletService.deleteWallet(id));
    }
}
