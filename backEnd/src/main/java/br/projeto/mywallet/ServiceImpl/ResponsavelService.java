package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.ResponsavelDTO;
import br.projeto.mywallet.Mappers.ResponsavelMapper;
import br.projeto.mywallet.Model.Responsavel;
import br.projeto.mywallet.Service.IResponsavelService;
import br.projeto.mywallet.repository.IResponsavelRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsavelService implements IResponsavelService {
    
    @Autowired
    private IResponsavelRepository responsavelRepository;

    @Override
    public ResponsavelDTO criarResponsavel(ResponsavelDTO responsavelDTO) {
        Responsavel responsavel = ResponsavelMapper.INSTANCE.toEntity(responsavelDTO);
        return ResponsavelMapper.INSTANCE.toDTO(responsavelRepository.save(responsavel));
    }

    @Override
    public ResponsavelDTO atualizarResponsavel(Long id, ResponsavelDTO responsavelAtualizado) {
        ResponsavelDTO responsavelDTO = buscarPorId(id);

        responsavelDTO.setNome(responsavelAtualizado.getNome());
        responsavelDTO.setTransacoes(responsavelAtualizado.getTransacoes());

        return ResponsavelMapper.INSTANCE.toDTO(responsavelRepository.save(ResponsavelMapper.INSTANCE.toEntity(responsavelDTO)));
    }

    @Override
    public void deletarResponsavel(Long id) {
        ResponsavelDTO responsavelDTO = buscarPorId(id);
        responsavelRepository.delete(ResponsavelMapper.INSTANCE.toEntity(responsavelDTO));
    }

    @Override
    public ResponsavelDTO buscarPorId(Long id) {
        Optional<Responsavel> responsavel = responsavelRepository.findById(id);
        return responsavel.map(ResponsavelMapper.INSTANCE::toDTO)
                .orElseThrow(() -> new RuntimeException("Responsável com o ID " + id + " não encontrado."));
    }

    @Override
    public List<ResponsavelDTO> listarTodos() {
        return responsavelRepository.findAll().stream()
                .map(ResponsavelMapper.INSTANCE::toDTO)
                .toList();
    }
}
