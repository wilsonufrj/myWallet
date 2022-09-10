package br.projeto.mywallet.Model;

import br.projeto.mywallet.DTO.GainDTO;
import br.projeto.mywallet.coreInterfaces.CoreDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import br.projeto.mywallet.coreInterfaces.Transaction;
import java.time.LocalDate;

/**
 *
 * @author wilson
 */
@Entity
@Table(name = "gain")
public class Gain implements Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double value;
    private String description;
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_wallet", referencedColumnName = "id")
    @JsonBackReference
    private Wallet wallet;

    public Gain() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Wallet getWallet() {
        return wallet;
    }

    @Override
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public static GainDTO convertToDTO(Transaction gain) {

        return new GainDTO(gain.getId(),
                gain.getValue(),
                gain.getDescription(),
                gain.getCreationDate());
    }

}
