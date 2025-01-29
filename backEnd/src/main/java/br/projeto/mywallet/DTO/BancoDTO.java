package br.projeto.mywallet.DTO;

import java.util.List;

/**
 *
 * @author wilsonramos
 */
public class BancoDTO {
    private Long id;
    
    private String nome;
   
    private List<TransacaoDTO> transcacoes;
    
    public BancoDTO(){}

    public BancoDTO(Long id, String nome, List<TransacaoDTO> transcacoes) {
        this.id = id;
        this.nome = nome;
        this.transcacoes = transcacoes;
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

    public List<TransacaoDTO> getTranscacoes() {
        return transcacoes;
    }

    public void setTranscacoes(List<TransacaoDTO> transcacoes) {
        this.transcacoes = transcacoes;
    }
    
    
}
