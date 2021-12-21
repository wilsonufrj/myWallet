package br.projeto.mywallet.repository;

import br.projeto.mywallet.Model.Spend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wilson
 */

@Repository
public interface SpendRepository extends JpaRepository<Spend, Long>{
    
}
