package br.projeto.mywallet.Mappers;

import br.projeto.mywallet.DTO.BancoDTO;
import br.projeto.mywallet.Model.Banco;
import org.mapstruct.Mapper;

/**
 *
 * @author wilsonramos
 */
@Mapper(uses = {TransacaoMapper.class})
public interface BancoMapper {
    
    BancoDTO toDTO(Banco banco);
    Banco toEntity(BancoDTO banco);
    
}
