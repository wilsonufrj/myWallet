package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.StatusDTO;
import br.projeto.mywallet.Mappers.StatusMapper;
import br.projeto.mywallet.Model.Status;
import br.projeto.mywallet.Service.IStatusService;
import br.projeto.mywallet.repository.IStatusRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService implements IStatusService {

    @Autowired
    private IStatusRepository statusRepository;

    @Override
    public StatusDTO criarStatus(StatusDTO statusDTO) {
        Status status = StatusMapper.INSTANCE.toEntity(statusDTO);
        return StatusMapper.INSTANCE.toDTO(statusRepository.save(status));
    }

    @Override
    public StatusDTO atualizarStatus(Long id, StatusDTO statusAtualizado) {
        StatusDTO statusDTO = buscarPorId(id);

        statusDTO.setNome(statusAtualizado.getNome());
        statusDTO.setTransacoes(statusAtualizado.getTransacoes());

        return StatusMapper.INSTANCE.toDTO(statusRepository.save(StatusMapper.INSTANCE.toEntity(statusDTO)));
    }

    @Override
    public void deletarStatus(Long id) {
        StatusDTO statusDTO = buscarPorId(id);
        statusRepository.delete(StatusMapper.INSTANCE.toEntity(statusDTO));
    }

    @Override
    public StatusDTO buscarPorId(Long id) {
        Optional<Status> status = statusRepository.findById(id);
        return status.map(StatusMapper.INSTANCE::toDTO)
                .orElseThrow(() -> new RuntimeException("Status com o ID " + id + " não encontrado."));
    }

    @Override
    public List<StatusDTO> listarTodos() {
        return statusRepository.findAll().stream()
                .map(StatusMapper.INSTANCE::toDTO)
                .toList();
    }
}
