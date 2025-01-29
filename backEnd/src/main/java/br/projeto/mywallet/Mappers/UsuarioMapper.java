package br.projeto.mywallet.Mappers;

import br.projeto.mywallet.DTO.UsuarioDTO;
import br.projeto.mywallet.Model.Usuario;
import org.mapstruct.Mapper;

/**
 *
 * @author wilsonramos
 */
@Mapper(uses = CarteiraMapper.class)
public interface UsuarioMapper {
    
    UsuarioDTO toDTO(Usuario usuario);
    
    Usuario toEntity(UsuarioDTO usuario);
    
}
