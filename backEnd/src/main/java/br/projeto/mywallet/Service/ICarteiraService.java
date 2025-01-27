package br.projeto.mywallet.Service;

import br.projeto.mywallet.Model.Carteira;
import java.util.List;

public interface ICarteiraService {
    Carteira criarCarteira(Carteira carteira); // Criar
    Carteira buscarCarteiraPorId(Long id); // Ler por ID
    List<Carteira> listarTodasCarteiras(); // Ler todas
    Carteira atualizarCarteira(Long id, Carteira carteira); // Atualizar
    void deletarCarteira(Long id); // Deletar
}
