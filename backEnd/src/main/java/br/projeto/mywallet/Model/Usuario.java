package br.projeto.mywallet.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wilsonramos
 */
@Entity
@Table(name = "Usuario")
public class Usuario {
    
    @Id
    private Long id;
    
    @Column(name = "nome",
            nullable = false)
    private String nome;
    
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Column(name = "email",
            nullable = false)
    private String email;
    
    @Column(name = "senha",
            nullable = false)
    private String senha;
    
    @ManyToMany
    @JoinTable(
        name = "Usuario_Carteira", // Nome da tabela intermediária
        joinColumns = @JoinColumn(name = "usuario_id"), 
        inverseJoinColumns = @JoinColumn(name = "carteira_id")
    )
    private Set<Carteira> carteiras = new HashSet<>();
            
    public Usuario() {
    }

    public Usuario(
            Long id,
            String nome,
            LocalDate dataNascimento,
            String email,
            String senha) {
        
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
        this.carteiras = new HashSet<>();
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Carteira> getCateiras() {
        return carteiras;
    }

    public void setCateiras(Set<Carteira> carteiras) {
        this.carteiras = carteiras;
    }
    
}
