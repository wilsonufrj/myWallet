package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.BancoDTO;
import br.projeto.mywallet.Mappers.BancoMapper;
import br.projeto.mywallet.Model.Banco;
import br.projeto.mywallet.Service.IBancoService;
import br.projeto.mywallet.exception.BancoJaExisteException;
import br.projeto.mywallet.exception.BancoNaoEncontradoException;
import br.projeto.mywallet.repository.IBancoRepository;
import java.util.List;
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

    @Autowired
    private BancoMapper bancoMapper = BancoMapper.INSTANCE;

    @Override
    public BancoDTO criarBanco(BancoDTO banco) {

        if (bancoRepository.findAll().stream().anyMatch(bancoAux -> bancoAux.getNome().equals(banco.getNome()))) {
            throw new BancoJaExisteException(banco.getNome());
        }

        Banco auxBanco = bancoMapper.toEntity(banco);

        return bancoMapper
                .toDTO(bancoRepository.save(auxBanco));
    }

    @Override
    public BancoDTO buscarBancoPorId(Long id) {

        Banco banco = bancoRepository.findById(id)
            .orElseThrow(() -> new BancoNaoEncontradoException(id));
            
        return bancoMapper.toDTO(banco);
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
        bancoDTO.setTransacoes(bancoAtualizado.getTransacoes());

        return bancoMapper
                .toDTO(bancoRepository.save(bancoMapper.toEntity(bancoDTO))
                );
    }

    @Override
    public void deletarBanco(Long id) {

        BancoDTO bancoDTO = buscarBancoPorId(id);

        bancoRepository.delete(bancoMapper.toEntity(bancoDTO));
    }

}
