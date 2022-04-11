package br.projeto.mywallet.Service;

import br.projeto.mywallet.DTO.SpendDTO;
import br.projeto.mywallet.Model.Spend;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceSpend {
    List<SpendDTO> getAllSpend();
    SpendDTO getSpend(Long id);
    SpendDTO addSpend(Spend spend);
    SpendDTO updateSpend(Long id,Spend spend);
    String deleteSpend(Long id);

}
