package br.projeto.mywallet.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wilsonramos
 */
@Entity
@Table(name = "Banco")
public class Banco {
    @Id
    private Long id;
    
    @Column(name = "banco")
    private String nome;
    
    @OneToMany(
            mappedBy = "banco",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Transacao> transcacoes;
    
    public Banco(){
        
    }

    public Banco(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeBanco() {
        return nome;
    }

    public void setNomeBanco(String nome) {
        this.nome = nome;
    }

    public List<Transacao> getTranscacoes() {
        return transcacoes;
    }

    public void setTranscacoes(List<Transacao> transcacoes) {
        this.transcacoes = transcacoes;
    }
    
    
}
