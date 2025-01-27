package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.Model.Mes;
import br.projeto.mywallet.Service.IMesService;
import br.projeto.mywallet.repository.IMesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesService implements IMesService {

    @Autowired
    private IMesRepository mesRepository;

    @Override
    public Mes criarMes(Mes mes) {
        return mesRepository.save(mes);
    }

    @Override
    public Mes atualizarMes(Long id, Mes mesAtualizado) {
        Optional<Mes> mesExistente = mesRepository.findById(id);
        if (mesExistente.isPresent()) {
            Mes mes = mesExistente.get();
            mes.setNome(mesAtualizado.getNome());
            mes.setAno(mesAtualizado.getAno());
            mes.setCarteira(mesAtualizado.getCarteira());
            mes.setTransacoes(mesAtualizado.getTransacoes());
            return mesRepository.save(mes);
        }
        throw new RuntimeException("Mês com o ID " + id + " não encontrado.");
    }

    @Override
    public void deletarMes(Long id) {
        if (mesRepository.existsById(id)) {
            mesRepository.deleteById(id);
        } else {
            throw new RuntimeException("Mês com o ID " + id + " não encontrado.");
        }
    }

    @Override
    public Mes buscarPorId(Long id) {
        return mesRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Mês com o ID " + id + " não encontrado."));
    }

    @Override
    public List<Mes> listarTodos() {
        return mesRepository.findAll();
    }
}
