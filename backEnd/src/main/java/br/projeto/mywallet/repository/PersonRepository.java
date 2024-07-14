package br.projeto.mywallet.repository;

import br.projeto.mywallet.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wilson
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
