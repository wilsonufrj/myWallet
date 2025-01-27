package br.projeto.mywallet.Service;

import br.projeto.mywallet.Model.TipoTransacao;
import java.util.List;

public interface ITipoTransacaoService {
    TipoTransacao criarTipoTransacao(TipoTransacao tipoTransacao);
    TipoTransacao atualizarTipoTransacao(Long id, TipoTransacao tipoTransacao);
    void deletarTipoTransacao(Long id);
    TipoTransacao buscarPorId(Long id);
    List<TipoTransacao> listarTodos();
}
