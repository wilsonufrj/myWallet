package br.projeto.mywallet.coreInterfaces;

import br.projeto.mywallet.Model.Wallet;
import java.time.LocalDate;


/**
 *
 * @author wilson
 */
public interface Transaction {

    void setWallet(Wallet wallet);
    
    void setId( Long id);

    void setValue(double value);

    void setDescription(String description);

    void setCreationDate(LocalDate date);
    
    Long getId();

    double getValue();

    String getDescription();

    LocalDate getCreationDate();

}
