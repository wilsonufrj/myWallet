package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.Model.Transacao;
import br.projeto.mywallet.Service.ITransacaoService;
import br.projeto.mywallet.repository.ITransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService implements ITransacaoService {

    @Autowired
    private ITransacaoRepository transacaoRepository;

    @Override
    public Transacao criarTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    @Override
    public Transacao atualizarTransacao(Long id, Transacao transacaoAtualizada) {
        Optional<Transacao> transacaoExistente = transacaoRepository.findById(id);
        if (transacaoExistente.isPresent()) {
            Transacao transacao = transacaoExistente.get();
            transacao.setData(transacaoAtualizada.getData());
            transacao.setDescricao(transacaoAtualizada.getDescricao());
            transacao.setValor(transacaoAtualizada.getValor());
            transacao.setQuantasVezes(transacaoAtualizada.getQuantasVezes());
            transacao.setBanco(transacaoAtualizada.getBanco());
            transacao.setFormaPagamento(transacaoAtualizada.getFormaPagamento());
            transacao.setStatus(transacaoAtualizada.getStatus());
            transacao.setResponsavel(transacaoAtualizada.getResponsavel());
            transacao.setMes(transacaoAtualizada.getMes());
            transacao.setTipoTransacao(transacaoAtualizada.getTipoTransacao());
            return transacaoRepository.save(transacao);
        }
        throw new RuntimeException("Transação com ID " + id + " não encontrada.");
    }

    @Override
    public void deletarTransacao(Long id) {
        if (transacaoRepository.existsById(id)) {
            transacaoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Transação com ID " + id + " não encontrada.");
        }
    }

    @Override
    public Transacao buscarPorId(Long id) {
        return transacaoRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Transação com ID " + id + " não encontrada."));
    }

    @Override
    public List<Transacao> listarTodas() {
        return transacaoRepository.findAll();
    }
}
