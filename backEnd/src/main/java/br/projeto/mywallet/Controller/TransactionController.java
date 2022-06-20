package br.projeto.mywallet.Controller;

import br.projeto.mywallet.DTO.TransactionDTO;
import br.projeto.mywallet.Service.ITransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wilson
 */

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {
    
    @Autowired
    ITransactionService serviceTransaction;
    
    @PostMapping
    public ResponseEntity addTransaction(@RequestBody TransactionDTO transactionDTO){
        return ResponseEntity.ok(serviceTransaction.addTransaction(transactionDTO));
    }
    
    @GetMapping
    public ResponseEntity getAllTransaction(){
        return ResponseEntity.ok(serviceTransaction.getAllTransaction());
    }
    
    @GetMapping(path="/{id}")
    public ResponseEntity getTransaction(@PathVariable Long id){
        return ResponseEntity.ok(serviceTransaction.getTransaction(id));
    }
    
    @PutMapping(path="/{id}")
    public ResponseEntity editTransaction(@PathVariable Long id, @RequestBody TransactionDTO transactionDTO){
        return ResponseEntity.ok(serviceTransaction.editTransaction(id, transactionDTO));
    }
    
    @DeleteMapping(path="/{id}")
    public ResponseEntity deleteTransaction(@PathVariable Long id){
        return ResponseEntity.ok(serviceTransaction.removeTransaction(id));
    }
    
}
