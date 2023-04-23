package br.projeto.mywallet.Controller;

import br.projeto.mywallet.DTO.TransactionDTO;
import br.projeto.mywallet.Service.ITransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity getTransaction(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .ok(serviceTransaction.getTransaction(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping(path="/{id}")
    public ResponseEntity addTransaction(@PathVariable Long id, @RequestBody TransactionDTO transactionDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(serviceTransaction.addTransaction(id, transactionDTO));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity editTransaction(@PathVariable Long id, @RequestBody TransactionDTO transactionDTO) {
        try {
            return ResponseEntity
                    .ok(serviceTransaction.editTransaction(id, transactionDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteTransaction(@PathVariable Long id) {
        serviceTransaction.removeTransaction(id);
        return ResponseEntity.ok().build();
    }

}
