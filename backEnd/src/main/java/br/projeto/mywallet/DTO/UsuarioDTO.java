package br.projeto.mywallet.DTO;

import java.time.LocalDate;
import java.util.Set;

/**
 *
 * @author wilsonramos
 */
public class UsuarioDTO {
    
    private Long id;
   
    private String nome;
    
    private LocalDate dataNascimento;
  
    private String email;
    
    private String senha;
    
    private Set<CarteiraDTO> carteiras;
    
    public UsuarioDTO(){}

    public UsuarioDTO(Long id, String nome, LocalDate dataNascimento, String email, String senha, Set<CarteiraDTO> carteiras) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
        this.carteiras = carteiras;
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

    public Set<CarteiraDTO> getCarteiras() {
        return carteiras;
    }

    public void setCarteiras(Set<CarteiraDTO> carteiras) {
        this.carteiras = carteiras;
    }
    
    
}
