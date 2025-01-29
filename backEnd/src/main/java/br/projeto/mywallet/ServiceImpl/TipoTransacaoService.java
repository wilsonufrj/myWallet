package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.TipoTransacaoDTO;
import br.projeto.mywallet.Mappers.TipoTransacaoMapper;
import br.projeto.mywallet.Model.TipoTransacao;
import br.projeto.mywallet.Service.ITipoTransacaoService;
import br.projeto.mywallet.repository.ITipoTransacaoRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoTransacaoService implements ITipoTransacaoService {

    @Autowired
    private ITipoTransacaoRepository tipoTransacaoRepository;

    @Override
    public TipoTransacaoDTO criarTipoTransacao(TipoTransacaoDTO tipoTransacaoDTO) {
        
        TipoTransacao tipoTransacao = TipoTransacaoMapper.INSTANCE.toEntity(tipoTransacaoDTO);
        
        return TipoTransacaoMapper.INSTANCE
                .toDTO(tipoTransacaoRepository.save(tipoTransacao));
    }

    @Override
    public TipoTransacaoDTO atualizarTipoTransacao(Long id, TipoTransacaoDTO tipoTransacaoAtualizado) {
        TipoTransacaoDTO tipoDTO = buscarPorId(id);

        tipoDTO.setNome(tipoTransacaoAtualizado.getNome());
        tipoDTO.setTransacoes(tipoTransacaoAtualizado.getTransacoes());

        return TipoTransacaoMapper.INSTANCE
                .toDTO(tipoTransacaoRepository.save(TipoTransacaoMapper.INSTANCE.toEntity(tipoDTO)));
    }

    @Override
    public void deletarTipoTransacao(Long id) {
        
        TipoTransacaoDTO tipoDTO = buscarPorId(id);
        tipoTransacaoRepository.delete(TipoTransacaoMapper.INSTANCE.toEntity(tipoDTO));
    }

    @Override
    public TipoTransacaoDTO buscarPorId(Long id) {
        
        Optional<TipoTransacao> tipoTransacao = tipoTransacaoRepository.findById(id);
        
        return tipoTransacao.map(TipoTransacaoMapper.INSTANCE::toDTO)
                .orElseThrow(() -> new RuntimeException("Tipo de Transação com o ID " + id + " não encontrado."));
    }

    @Override
    public List<TipoTransacaoDTO> listarTodos() {
        
        return tipoTransacaoRepository.findAll().stream()
                .map(TipoTransacaoMapper.INSTANCE::toDTO)
                .toList();
    }
}
