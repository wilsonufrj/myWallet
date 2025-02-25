package br.projeto.mywallet.DTO;

/**
 *
 * @author wilsonramos
 */
public class AuthenticateDTO {
    private String token;
    private String nome;
    private Long id;

    public AuthenticateDTO(String token, String nome, Long id) {
        this.token = token;
        this.nome = nome;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
