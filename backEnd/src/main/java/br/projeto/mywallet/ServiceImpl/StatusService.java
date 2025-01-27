package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.Model.Status;
import br.projeto.mywallet.Service.IStatusService;
import br.projeto.mywallet.repository.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService implements IStatusService {

    @Autowired
    private IStatusRepository statusRepository;

    @Override
    public Status criarStatus(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public Status atualizarStatus(Long id, Status statusAtualizado) {
        Optional<Status> statusExistente = statusRepository.findById(id);
        if (statusExistente.isPresent()) {
            Status status = statusExistente.get();
            status.setNome(statusAtualizado.getNome());
            status.setTransacoes(statusAtualizado.getTransacoes());
            return statusRepository.save(status);
        }
        throw new RuntimeException("Status com o ID " + id + " não encontrado.");
    }

    @Override
    public void deletarStatus(Long id) {
        if (statusRepository.existsById(id)) {
            statusRepository.deleteById(id);
        } else {
            throw new RuntimeException("Status com o ID " + id + " não encontrado.");
        }
    }

    @Override
    public Status buscarPorId(Long id) {
        return statusRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Status com o ID " + id + " não encontrado."));
    }

    @Override
    public List<Status> listarTodos() {
        return statusRepository.findAll();
    }
}
