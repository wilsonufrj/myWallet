package br.projeto.mywallet.Mappers;

import br.projeto.mywallet.DTO.FormaPagamentoDTO;
import br.projeto.mywallet.Model.FormaPagamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author wilsonramos
 */
@Mapper(uses = TransacaoMapper.class)
public interface FormaPagamentoMapper {
    
    FormaPagamentoMapper INSTANCE = Mappers.getMapper(FormaPagamentoMapper.class);
    
    FormaPagamentoDTO toDTO(FormaPagamento formaPagamento);
    FormaPagamento toEntity(FormaPagamentoDTO formaPagamentoDTO);
    
}
