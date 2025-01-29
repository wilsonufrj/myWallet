package br.projeto.mywallet.Mappers;

import br.projeto.mywallet.DTO.ResponsavelDTO;
import br.projeto.mywallet.Model.Responsavel;
import org.mapstruct.Mapper;

/**
 *
 * @author wilsonramos
 */
@Mapper(uses = TransacaoMapper.class)
public interface ResponsavelMapper {
    
    ResponsavelDTO toDTO(Responsavel responsavel);
    
    Responsavel toEntity(ResponsavelDTO responsavelDTO);
    
}
