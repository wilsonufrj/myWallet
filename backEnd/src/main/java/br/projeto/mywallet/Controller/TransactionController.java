package br.projeto.mywallet.Controller;

import br.projeto.mywallet.DTO.TransactionDTO;
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
    
//    @Autowired
//    ITransactionService serviceTransaction;
//    
//    
//    @GetMapping(path="/{id}")
//    public ResponseEntity getTransaction(@PathVariable Long id){
//        return ResponseEntity.ok(serviceTransaction.getTransaction(id));
//    }
//    
//    @PutMapping(path="/{id}")
//    public ResponseEntity editTransaction(@PathVariable Long id, @RequestBody TransactionDTO transactionDTO){
//        serviceTransaction.editTransaction(id, transactionDTO);
//        return ResponseEntity.ok().build();
//    }
//    
//    @DeleteMapping(path="/{id}")
//    public ResponseEntity deleteTransaction(@PathVariable Long id){
//        serviceTransaction.removeTransaction(id);
//        return ResponseEntity.ok().build();
//    }
    
}
