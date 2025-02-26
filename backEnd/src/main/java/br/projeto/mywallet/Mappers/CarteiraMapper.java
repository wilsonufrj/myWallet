package br.projeto.mywallet.Mappers;

import br.projeto.mywallet.DTO.CarteiraDTO;
import br.projeto.mywallet.Model.Carteira;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author wilsonramos
 */
@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, MesMapper.class})
public interface CarteiraMapper {

    CarteiraMapper INSTANCE = Mappers.getMapper(CarteiraMapper.class);

    @Mapping(target = "usuarios", ignore = true)
    CarteiraDTO toDTO(Carteira carteira);

    @Mapping(target = "usuarios", ignore = true)
    Carteira toEntity(CarteiraDTO carteiraDTO);

}
