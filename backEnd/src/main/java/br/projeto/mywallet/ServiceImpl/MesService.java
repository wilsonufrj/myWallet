package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.MesDTO;
import br.projeto.mywallet.Mappers.MesMapper;
import br.projeto.mywallet.Model.Mes;
import br.projeto.mywallet.Service.IMesService;
import br.projeto.mywallet.repository.IMesRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesService implements IMesService {

    @Autowired
    private IMesRepository mesRepository;

    @Override
    public MesDTO criarMes(MesDTO mesDTO) {
        Mes mes = MesMapper.INSTANCE.toEntity(mesDTO);
        return MesMapper.INSTANCE.toDTO(mesRepository.save(mes));
    }

    @Override
    public MesDTO atualizarMes(Long id, MesDTO mesAtualizado) {
        MesDTO mesDTO = buscarPorId(id);

        mesDTO.setNome(mesAtualizado.getNome());
        mesDTO.setAno(mesAtualizado.getAno());
        mesDTO.setCarteira(mesAtualizado.getCarteira());
        mesDTO.setTransacoes(mesAtualizado.getTransacoes());

        return MesMapper.INSTANCE.toDTO(mesRepository.save(MesMapper.INSTANCE.toEntity(mesDTO)));
    }

    @Override
    public void deletarMes(Long id) {
        MesDTO mesDTO = buscarPorId(id);
        mesRepository.delete(MesMapper.INSTANCE.toEntity(mesDTO));
    }

    @Override
    public MesDTO buscarPorId(Long id) {
        Optional<Mes> mes = mesRepository.findById(id);
        return mes.map(MesMapper.INSTANCE::toDTO)
                .orElseThrow(() -> new RuntimeException("Mês com o ID " + id + " não encontrado."));
    }

    @Override
    public List<MesDTO> listarTodos() {
        return mesRepository.findAll().stream()
                .map(MesMapper.INSTANCE::toDTO)
                .toList();
    }
}
