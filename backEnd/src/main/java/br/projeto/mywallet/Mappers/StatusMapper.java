package br.projeto.mywallet.Mappers;

import br.projeto.mywallet.DTO.StatusDTO;
import br.projeto.mywallet.Model.Status;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author wilsonramos
 */
@Mapper(uses = TransacaoMapper.class)
public interface StatusMapper {
    
    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

    
    StatusDTO toDTO(Status status);
    
    Status toEntity(StatusDTO statusDTO);
    
}
