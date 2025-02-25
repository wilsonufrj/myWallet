package br.projeto.mywallet.Service;

import br.projeto.mywallet.DTO.CarteiraDTO;
import java.util.List;

public interface ICarteiraService {

    CarteiraDTO criarCarteira(CarteiraDTO carteira);

    CarteiraDTO buscarCarteiraPorId(Long id); 

    List<CarteiraDTO> buscaCarteiraPorUsuario(String nomeUsuario);

    List<CarteiraDTO> listarTodasCarteiras(); 

    CarteiraDTO atualizarCarteira(Long id, CarteiraDTO carteiraDTO); 

    void deletarCarteira(Long id); 
}
