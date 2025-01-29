package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.BancoDTO;
import br.projeto.mywallet.Mappers.BancoMapper;
import br.projeto.mywallet.Model.Banco;
import br.projeto.mywallet.Service.IBancoService;
import br.projeto.mywallet.repository.IBancoRepository;
import java.util.List;
import java.util.Optional;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wilsonramos
 */
@Service
public class BancoService implements IBancoService {
    
    private final BancoMapper bancoMapper = Mappers.getMapper(BancoMapper.class);
    
    @Autowired
    private IBancoRepository bancoRepository;
    
    @Override
    public BancoDTO criarBanco(BancoDTO banco) {
        Banco auxBanco = bancoMapper.toEntity(banco);
        return bancoMapper.toDTO(bancoRepository.save(auxBanco));
    }

    @Override
    public BancoDTO buscarBancoPorId(Long id) {
        
        Optional<Banco> banco = bancoRepository.findById(id);
        
        return banco.isPresent()
                ?bancoMapper.toDTO(banco.get())
                :null;
    }

    @Override
    public List<BancoDTO> listarTodosBancos() {
        
        return bancoRepository.findAll().stream()
                .map(bancoMapper::toDTO)
                .toList();
    }

    @Override
    public BancoDTO atualizarBanco(Long id, BancoDTO bancoAtualizado) {
        BancoDTO bancoDTO = buscarBancoPorId(id); 
        
        bancoDTO.setNome(bancoAtualizado.getNome());
        bancoDTO.setTranscacoes(bancoAtualizado.getTranscacoes());
        
        return bancoMapper.toDTO(
                bancoRepository.save(bancoMapper.toEntity(bancoDTO))
        );
    }

    @Override
    public void deletarBanco(Long id) {
        BancoDTO bancoDTO = buscarBancoPorId(id);
        bancoRepository.delete(bancoMapper.toEntity(bancoDTO)); 
    }
}
