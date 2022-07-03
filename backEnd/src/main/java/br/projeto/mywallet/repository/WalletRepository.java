package br.projeto.mywallet.repository;

import br.projeto.mywallet.Model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wilson
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long>{
    
}
