package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.SpendDTO;
import br.projeto.mywallet.Model.Spend;
import br.projeto.mywallet.Service.IServiceSpend;
import br.projeto.mywallet.repository.SpendRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SpendServiceImpl implements IServiceSpend {

    @Autowired
    private SpendRepository spendRepository;

    @Override
    public List<SpendDTO> getAllSpend() {
        return spendRepository.findAll()
                .stream()
                .map(spend -> spend.convertDTO())
                .collect(Collectors.toList());
    }

    @Override
    public SpendDTO getSpend(Long id) throws RuntimeException {
        Optional<Spend> spend = spendRepository.findById(id);
        if(spend.isEmpty()){
            throw new RuntimeException("Spend not found");
        }

        return spend.get().convertDTO();
    }

    @Override
    public SpendDTO addSpend(Spend spend) {
        return spendRepository.save(spend).convertDTO();
    }

    @Override
    public SpendDTO updateSpend(Long id, Spend spend) throws RuntimeException {
        Optional<Spend> spendDataBase = spendRepository.findById(id);
        if(spendDataBase.isEmpty()){
            throw new RuntimeException("Spend not found");
        }

        Spend spendAux = spendDataBase.get();
        spendAux.setValue(spend.getValue());
        spendAux.setDay(spend.getDay());
        spendAux.setLocation(spend.getLocation());
        spendAux.setDescription(spend.getDescription());
        spendAux.setItMonthly(spend.isItMonthly());

        return spendAux.convertDTO();
    }

    @Override
    public String deleteSpend(Long id) {
        Optional<Spend> spend = spendRepository.findById(id);
        if(spend.isEmpty()){
            throw new RuntimeException("Spend not found");
        }
        spendRepository.delete(spend.get());
        return "Spend has been deleted";
    }
}
