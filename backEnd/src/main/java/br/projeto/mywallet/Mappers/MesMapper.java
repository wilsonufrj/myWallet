package br.projeto.mywallet.Mappers;

import br.projeto.mywallet.DTO.MesDTO;
import br.projeto.mywallet.Model.Mes;
import org.mapstruct.Mapper;

/**
 *
 * @author wilsonramos
 */
@Mapper(uses = CarteiraMapper.class)
public interface MesMapper {
    MesDTO toDTO(Mes mes);
    Mes toEntity(MesDTO mes);
}
