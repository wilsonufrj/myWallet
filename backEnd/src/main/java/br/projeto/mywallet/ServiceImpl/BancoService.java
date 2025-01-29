package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.BancoDTO;
import br.projeto.mywallet.Mappers.BancoMapper;
import br.projeto.mywallet.Model.Banco;
import br.projeto.mywallet.Service.IBancoService;
import br.projeto.mywallet.repository.IBancoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wilsonramos
 */
@Service
public class BancoService implements IBancoService {
    
    @Autowired
    private IBancoRepository bancoRepository;
    
    @Override
    public BancoDTO criarBanco(BancoDTO banco) {
        
        Banco auxBanco = BancoMapper.INSTANCE.toEntity(banco);
        
        return BancoMapper.INSTANCE
                .toDTO(bancoRepository.save(auxBanco));
    }

    @Override
    public BancoDTO buscarBancoPorId(Long id) {
        
        Optional<Banco> banco = bancoRepository.findById(id);
        
        return banco.map(BancoMapper.INSTANCE::toDTO)
                .orElseThrow(() -> new RuntimeException("Banco não encontrado com ID: " + id));
    }

    @Override
    public List<BancoDTO> listarTodosBancos() {
        
        return bancoRepository.findAll().stream()
                .map(BancoMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    public BancoDTO atualizarBanco(Long id, BancoDTO bancoAtualizado) {
        
        BancoDTO bancoDTO = buscarBancoPorId(id); 
        
        bancoDTO.setNome(bancoAtualizado.getNome());
        bancoDTO.setTranscacoes(bancoAtualizado.getTranscacoes());
        
        return BancoMapper.INSTANCE
                .toDTO(bancoRepository.save(BancoMapper.INSTANCE.toEntity(bancoDTO))
        );
    }

    @Override
    public void deletarBanco(Long id) {
        
        BancoDTO bancoDTO = buscarBancoPorId(id);
        
        bancoRepository.delete(BancoMapper.INSTANCE.toEntity(bancoDTO)); 
    }
}
