package br.projeto.mywallet.Service;

import br.projeto.mywallet.Model.Responsavel;
import java.util.List;

public interface IResponsavelService {
    Responsavel criarResponsavel(Responsavel responsavel);
    Responsavel atualizarResponsavel(Long id, Responsavel responsavel);
    void deletarResponsavel(Long id);
    Responsavel buscarPorId(Long id);
    List<Responsavel> listarTodos();
}
