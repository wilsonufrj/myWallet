package br.projeto.mywallet.Mappers;

import br.projeto.mywallet.DTO.BancoDTO;
import br.projeto.mywallet.Model.Banco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author wilsonramos
 */
@Mapper(uses = {TransacaoMapper.class})
public interface BancoMapper {
    BancoMapper INSTANCE = Mappers.getMapper(BancoMapper.class);
     
    BancoDTO toDTO(Banco banco);
    Banco toEntity(BancoDTO banco);
    
}
