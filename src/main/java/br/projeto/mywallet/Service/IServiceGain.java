package br.projeto.mywallet.Service;

import br.projeto.mywallet.DTO.GainDTO;
import br.projeto.mywallet.Model.Gain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceGain {
    List<GainDTO> allGain();
    GainDTO addGain(Gain gain);
    GainDTO readGain(Long id);
    GainDTO updateGain(Long id,Gain gain);
    String deleteGain(Long id);

}
