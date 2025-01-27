package br.projeto.mywallet.Service;

import br.projeto.mywallet.Model.Mes;
import java.util.List;

public interface IMesService {
    Mes criarMes(Mes mes);
    Mes atualizarMes(Long id, Mes mes);
    void deletarMes(Long id);
    Mes buscarPorId(Long id);
    List<Mes> listarTodos();
}
