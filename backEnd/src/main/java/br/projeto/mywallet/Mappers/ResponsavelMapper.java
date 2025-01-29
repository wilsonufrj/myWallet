package br.projeto.mywallet.Mappers;

import br.projeto.mywallet.DTO.ResponsavelDTO;
import br.projeto.mywallet.Model.Responsavel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author wilsonramos
 */
@Mapper(uses = TransacaoMapper.class)
public interface ResponsavelMapper {
    
    ResponsavelMapper INSTANCE = Mappers.getMapper(ResponsavelMapper.class);

    
    ResponsavelDTO toDTO(Responsavel responsavel);
    
    Responsavel toEntity(ResponsavelDTO responsavelDTO);
    
}
