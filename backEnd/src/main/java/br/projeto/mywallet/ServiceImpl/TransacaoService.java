package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.TransacaoDTO;
import br.projeto.mywallet.Mappers.TransacaoMapper;
import br.projeto.mywallet.Model.*;
import br.projeto.mywallet.Service.ITransacaoService;
import br.projeto.mywallet.repository.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService implements ITransacaoService {

    @Autowired
    private ITransacaoRepository transacaoRepository;

    @Autowired
    private IBancoRepository bancoRepository;

    @Autowired
    private IFormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private IStatusRepository statusRepository;

    @Autowired
    private IResponsavelRepository responsavelRepository;

    @Autowired
    private IMesRepository mesRepository;

    @Autowired
    private ITipoTransacaoRepository tipoTransacaoRepository;

    @Autowired
    private TransacaoMapper transacaoMapper = TransacaoMapper.INSTANCE;
    
    @Override
    public TransacaoDTO criarTransacao(TransacaoDTO transacaoDTO) throws Exception{
        
        Transacao transacao = transacaoMapper.toEntity(transacaoDTO);

        Banco banco = bancoRepository.findById(transacao.getBanco().getId())
                .orElseThrow(()-> new Exception("Banco nao encontrado"));

        FormaPagamento formaPagamento = formaPagamentoRepository.findById(transacao.getFormaPagamento().getId())
                .orElseThrow(()-> new Exception("Forma de pagamento nao encontrada"));

        Status status = statusRepository.findById(transacao.getStatus().getId())
                .orElseThrow(()-> new Exception("Status nao encontrado"));

        Responsavel responsavel = responsavelRepository.findById(transacao.getResponsavel().getId())
                .orElseThrow(()-> new Exception("Responsavel nao encontrado"));

        transacao.setBanco(banco);
        transacao.setFormaPagamento(formaPagamento);
        transacao.setStatus(status);
        transacao.setResponsavel(responsavel);
        transacao.setReceita(true);

        return transacaoMapper
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

        return transacaoMapper
                .toDTO(transacaoRepository.save(transacaoMapper.toEntity(transacaoDTO)));
    }

    @Override
    public void deletarTransacao(Long id) {
        
        TransacaoDTO transacaoDTO = buscarPorId(id);
        
        transacaoRepository.delete(transacaoMapper.toEntity(transacaoDTO));
    }

    @Override
    public TransacaoDTO buscarPorId(Long id) {
        
        Optional<Transacao> transacao = transacaoRepository.findById(id);
        
        return transacao.map(transacaoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Transação com ID " + id + " não encontrada."));
    }

    @Override
    public List<TransacaoDTO> listarTodas() {
        
        return transacaoRepository.findAll().stream()
                .map(transacaoMapper::toDTO)
                .toList();
    }
}
