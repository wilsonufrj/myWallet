package br.projeto.mywallet.Mappers;

import br.projeto.mywallet.DTO.StatusDTO;
import br.projeto.mywallet.Model.Status;
import org.mapstruct.Mapper;

/**
 *
 * @author wilsonramos
 */
@Mapper(uses = TransacaoMapper.class)
public interface StatusMapper {
    
    StatusDTO toDTO(Status status);
    
    Status toEntity(StatusDTO statusDTO);
    
}
