package br.projeto.mywallet.Service;

import br.projeto.mywallet.DTO.CarteiraDTO;
import br.projeto.mywallet.Model.Carteira;
import java.util.List;

public interface ICarteiraService {
    CarteiraDTO criarCarteira(CarteiraDTO carteira); // Criar
    CarteiraDTO buscarCarteiraPorId(Long id); // Ler por ID
    List<CarteiraDTO> listarTodasCarteiras(); // Ler todas
    CarteiraDTO atualizarCarteira(Long id, CarteiraDTO carteiraDTO); // Atualizar
    void deletarCarteira(Long id); // Deletar
}
