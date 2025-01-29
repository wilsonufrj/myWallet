package br.projeto.mywallet.Mappers;

import br.projeto.mywallet.DTO.MesDTO;
import br.projeto.mywallet.Model.Mes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author wilsonramos
 */
@Mapper(uses = CarteiraMapper.class)
public interface MesMapper {
    
    MesMapper INSTANCE = Mappers.getMapper(MesMapper.class);

    
    MesDTO toDTO(Mes mes);
    
    Mes toEntity(MesDTO mes);
    
}
