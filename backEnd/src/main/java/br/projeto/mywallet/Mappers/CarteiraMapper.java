package br.projeto.mywallet.Mappers;

import br.projeto.mywallet.DTO.CarteiraDTO;
import br.projeto.mywallet.Model.Carteira;
import org.mapstruct.Mapper;

/**
 *
 * @author wilsonramos
 */
@Mapper(uses = {UsuarioMapper.class, MesMapper.class})
public interface CarteiraMapper {
    
    CarteiraDTO toDTO(Carteira carteira);
    Carteira toEntity(CarteiraDTO carteiraDTO);
    
}
