package br.projeto.mywallet.Controller;

import br.projeto.mywallet.DTO.WalletDTO;

import br.projeto.mywallet.Service.IWalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity getWallet(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(walletService.getWallet(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getAllWallets() {
        return ResponseEntity.ok(walletService.getAllWallets());
    }

    @PostMapping
    public ResponseEntity createWallet(@RequestBody WalletDTO walletDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(walletService.createWallet(walletDTO));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity udateWallet(@PathVariable Long id, @RequestBody WalletDTO walletDTO) {
        try {
            return ResponseEntity.ok(walletService.updateWallet(id, walletDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteWallet(@PathVariable Long id) {
        walletService.deleteWallet(id);
        return ResponseEntity.ok().build();
    }
}
