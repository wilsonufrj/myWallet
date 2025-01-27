package br.projeto.mywallet.Service;

import br.projeto.mywallet.Model.Transacao;
import java.util.List;

public interface ITransacaoService {
    Transacao criarTransacao(Transacao transacao);
    Transacao atualizarTransacao(Long id, Transacao transacaoAtualizada);
    void deletarTransacao(Long id);
    Transacao buscarPorId(Long id);
    List<Transacao> listarTodas();
}
