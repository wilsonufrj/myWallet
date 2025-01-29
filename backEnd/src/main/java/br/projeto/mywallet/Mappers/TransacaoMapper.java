package br.projeto.mywallet.Mappers;

import br.projeto.mywallet.DTO.TransacaoDTO;
import br.projeto.mywallet.Model.Transacao;
import org.mapstruct.Mapper;

/**
 *
 * @author wilsonramos
 */
@Mapper(uses = {
    BancoMapper.class,
    FormaPagamentoMapper.class,
    StatusMapper.class,
    ResponsavelMapper.class,
    MesMapper.class,
    TipoTransacaoMapper.class})
public interface TransacaoMapper {
    
    TransacaoDTO toDTO(Transacao transacao);
    
    Transacao toEntity(TransacaoDTO transacaoDTO);
    
}
