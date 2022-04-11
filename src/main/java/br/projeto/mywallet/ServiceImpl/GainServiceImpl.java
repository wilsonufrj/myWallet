package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.GainDTO;
import br.projeto.mywallet.Model.Gain;
import br.projeto.mywallet.Service.IServiceGain;
import br.projeto.mywallet.repository.GainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GainServiceImpl implements IServiceGain {

    @Autowired
    GainRepository gainRepository;

    @Override
    public List<GainDTO> allGain() {
        return gainRepository.findAll()
                .stream()
                .map(gain -> gain.convertDTO())
                .collect(Collectors.toList());
    }

    @Override
    public GainDTO addGain(Gain gain) {
        return gainRepository.save(gain).convertDTO();
    }

    @Override
    public GainDTO readGain(Long id) throws RuntimeException  {
        Optional<Gain> gain = gainRepository.findById(id);

        if(gain.isEmpty()){
            throw new RuntimeException("Gain not found") ;
        }

        return gain.get().convertDTO();
    }

    @Override
    public GainDTO updateGain(Long id, Gain gain) throws RuntimeException {
        Optional<Gain> gainDataBase = gainRepository.findById(id);
        if(gainDataBase.isEmpty()){
            throw new RuntimeException("Gain not found");
        }

        Gain gainAux = gainDataBase.get();
        gainAux.setDay(gain.getDay());
        gainAux.setDescription(gain.getDescription());
        gainAux.setValue(gain.getValue());
        gainAux.setItMonthly(gain.isItMonthly());

        gainRepository.save(gainAux);

        return gainAux.convertDTO();
    }

    @Override
    public String deleteGain(Long id) throws RuntimeException {
        Optional<Gain> gain = gainRepository.findById(id);
        if(gain.isEmpty()){
            throw new RuntimeException("Gain not found");
        }
        gainRepository.delete(gain.get());

        return "Gain it has been deleted";
    }
}
