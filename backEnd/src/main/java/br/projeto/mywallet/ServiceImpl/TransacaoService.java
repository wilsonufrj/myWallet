package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.TransacaoDTO;
import br.projeto.mywallet.Mappers.TransacaoMapper;
import br.projeto.mywallet.Model.Transacao;
import br.projeto.mywallet.Service.ITransacaoService;
import br.projeto.mywallet.repository.ITransacaoRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService implements ITransacaoService {

    @Autowired
    private ITransacaoRepository transacaoRepository;

    @Override
    public TransacaoDTO criarTransacao(TransacaoDTO transacaoDTO) {
        
        Transacao transacao = TransacaoMapper.INSTANCE.toEntity(transacaoDTO);
        
        return TransacaoMapper.INSTANCE
                .toDTO(transacaoRepository.save(transacao));
    }

    @Override
    public TransacaoDTO atualizarTransacao(Long id, TransacaoDTO transacaoAtualizada) {
        
        TransacaoDTO transacaoDTO = buscarPorId(id);

        transacaoDTO.setData(transacaoAtualizada.getData());
        transacaoDTO.setDescricao(transacaoAtualizada.getDescricao());
        transacaoDTO.setValor(transacaoAtualizada.getValor());
        transacaoDTO.setQuantasVezes(transacaoAtualizada.getQuantasVezes());
        transacaoDTO.setBanco(transacaoAtualizada.getBanco());
        transacaoDTO.setFormaPagamento(transacaoAtualizada.getFormaPagamento());
        transacaoDTO.setStatus(transacaoAtualizada.getStatus());
        transacaoDTO.setResponsavel(transacaoAtualizada.getResponsavel());
        transacaoDTO.setMes(transacaoAtualizada.getMes());
        transacaoDTO.setTipoTransacao(transacaoAtualizada.getTipoTransacao());

        return TransacaoMapper.INSTANCE
                .toDTO(transacaoRepository.save(TransacaoMapper.INSTANCE.toEntity(transacaoDTO)));
    }

    @Override
    public void deletarTransacao(Long id) {
        
        TransacaoDTO transacaoDTO = buscarPorId(id);
        
        transacaoRepository.delete(TransacaoMapper.INSTANCE.toEntity(transacaoDTO));
    }

    @Override
    public TransacaoDTO buscarPorId(Long id) {
        
        Optional<Transacao> transacao = transacaoRepository.findById(id);
        
        return transacao.map(TransacaoMapper.INSTANCE::toDTO)
                .orElseThrow(() -> new RuntimeException("Transação com ID " + id + " não encontrada."));
    }

    @Override
    public List<TransacaoDTO> listarTodas() {
        
        return transacaoRepository.findAll().stream()
                .map(TransacaoMapper.INSTANCE::toDTO)
                .toList();
    }
}
