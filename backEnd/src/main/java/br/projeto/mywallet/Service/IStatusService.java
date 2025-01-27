package br.projeto.mywallet.Service;

import br.projeto.mywallet.Model.Status;
import java.util.List;

public interface IStatusService {
    Status criarStatus(Status status);
    Status atualizarStatus(Long id, Status status);
    void deletarStatus(Long id);
    Status buscarPorId(Long id);
    List<Status> listarTodos();
}
