package br.projeto.mywallet.Mappers;

import br.projeto.mywallet.DTO.FormaPagamentoDTO;
import br.projeto.mywallet.Model.FormaPagamento;
import org.mapstruct.Mapper;

/**
 *
 * @author wilsonramos
 */
@Mapper(uses = TransacaoMapper.class)
public interface FormaPagamentoMapper {
    
    FormaPagamentoDTO toDTO(FormaPagamento formaPagamento);
    FormaPagamento toEntity(FormaPagamentoDTO formaPagamentoDTO);
    
}
