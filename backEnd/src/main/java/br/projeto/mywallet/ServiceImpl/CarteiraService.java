package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.Model.Carteira;
import br.projeto.mywallet.Service.ICarteiraService;
import br.projeto.mywallet.repository.ICarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteiraService implements ICarteiraService {

    @Autowired
    private ICarteiraRepository carteiraRepository;

    @Override
    public Carteira criarCarteira(Carteira carteira) {
        return carteiraRepository.save(carteira); // Salva a carteira no banco de dados
    }

    @Override
    public Carteira buscarCarteiraPorId(Long id) {
        Optional<Carteira> carteira = carteiraRepository.findById(id);
        return carteira.orElseThrow(() -> new RuntimeException("Carteira não encontrada com ID: " + id));
    }

    @Override
    public List<Carteira> listarTodasCarteiras() {
        return carteiraRepository.findAll();
    }

    @Override
    public Carteira atualizarCarteira(Long id, Carteira carteiraAtualizada) {
        Carteira carteira = buscarCarteiraPorId(id); // Verifica se a carteira existe
        carteira.setNome(carteiraAtualizada.getNome());
        carteira.setMeses(carteiraAtualizada.getMeses());
        carteira.setUsuarios(carteiraAtualizada.getUsuarios());
        return carteiraRepository.save(carteira); // Atualiza e salva
    }

    @Override
    public void deletarCarteira(Long id) {
        Carteira carteira = buscarCarteiraPorId(id); // Verifica se a carteira existe
        carteiraRepository.delete(carteira); // Remove do banco de dados
    }
}
