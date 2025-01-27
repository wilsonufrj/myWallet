package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.Model.TipoTransacao;
import br.projeto.mywallet.Service.ITipoTransacaoService;
import br.projeto.mywallet.repository.ITipoTransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoTransacaoService implements ITipoTransacaoService {

    @Autowired
    private ITipoTransacaoRepository tipoTransacaoRepository;

    @Override
    public TipoTransacao criarTipoTransacao(TipoTransacao tipoTransacao) {
        return tipoTransacaoRepository.save(tipoTransacao);
    }

    @Override
    public TipoTransacao atualizarTipoTransacao(Long id, TipoTransacao tipoTransacaoAtualizado) {
        Optional<TipoTransacao> tipoExistente = tipoTransacaoRepository.findById(id);
        if (tipoExistente.isPresent()) {
            TipoTransacao tipoTransacao = tipoExistente.get();
            tipoTransacao.setNome(tipoTransacaoAtualizado.getNome());
            tipoTransacao.setTransacoes(tipoTransacaoAtualizado.getTransacoes());
            return tipoTransacaoRepository.save(tipoTransacao);
        }
        throw new RuntimeException("Tipo de Transação com o ID " + id + " não encontrado.");
    }

    @Override
    public void deletarTipoTransacao(Long id) {
        if (tipoTransacaoRepository.existsById(id)) {
            tipoTransacaoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tipo de Transação com o ID " + id + " não encontrado.");
        }
    }

    @Override
    public TipoTransacao buscarPorId(Long id) {
        return tipoTransacaoRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Tipo de Transação com o ID " + id + " não encontrado."));
    }

    @Override
    public List<TipoTransacao> listarTodos() {
        return tipoTransacaoRepository.findAll();
    }
}
