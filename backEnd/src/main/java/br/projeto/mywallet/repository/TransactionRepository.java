package br.projeto.mywallet.repository;

import br.projeto.mywallet.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author wilson
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
}
