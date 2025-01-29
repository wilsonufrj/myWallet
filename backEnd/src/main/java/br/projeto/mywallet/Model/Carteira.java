package br.projeto.mywallet.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wilsonramos
 */
@Entity
@Table(name = "Carteira")
public class Carteira {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 

    private Long id;
    
    @Column(name = "nome",
            nullable = false )
    private String nome;
    
    @ManyToMany(mappedBy = "carteiras") // Relacionamento bidirecional
    private Set<Usuario> usuarios;
    
    @OneToMany(mappedBy = "carteira",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Mes> meses;
    
    public Carteira(){}

    public Carteira(Long id, String nome, Set<Usuario> usuarios, List<Mes> meses) {
        this.id = id;
        this.nome = nome;
        this.usuarios = usuarios;
        this.meses = meses;
    }    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Mes> getMeses() {
        return meses;
    }

    public void setMeses(List<Mes> meses) {
        this.meses = meses;
    }
}
