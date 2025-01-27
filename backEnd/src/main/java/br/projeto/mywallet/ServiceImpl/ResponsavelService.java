package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.Model.Responsavel;
import br.projeto.mywallet.Service.IResponsavelService;
import br.projeto.mywallet.repository.IResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsavelService implements IResponsavelService {

    @Autowired
    private IResponsavelRepository responsavelRepository;

    @Override
    public Responsavel criarResponsavel(Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    @Override
    public Responsavel atualizarResponsavel(Long id, Responsavel responsavelAtualizado) {
        Optional<Responsavel> responsavelExistente = responsavelRepository.findById(id);
        if (responsavelExistente.isPresent()) {
            Responsavel responsavel = responsavelExistente.get();
            responsavel.setNome(responsavelAtualizado.getNome());
            responsavel.setTransacoes(responsavelAtualizado.getTransacoes());
            return responsavelRepository.save(responsavel);
        }
        throw new RuntimeException("Responsável com o ID " + id + " não encontrado.");
    }

    @Override
    public void deletarResponsavel(Long id) {
        if (responsavelRepository.existsById(id)) {
            responsavelRepository.deleteById(id);
        } else {
            throw new RuntimeException("Responsável com o ID " + id + " não encontrado.");
        }
    }

    @Override
    public Responsavel buscarPorId(Long id) {
        return responsavelRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Responsável com o ID " + id + " não encontrado."));
    }

    @Override
    public List<Responsavel> listarTodos() {
        return responsavelRepository.findAll();
    }
}
