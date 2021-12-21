package br.projeto.mywallet.Controller;

import br.projeto.mywallet.Model.Spend;
import br.projeto.mywallet.repository.SpendRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wilson
 */

@RestController
@RequestMapping("/spend")
public class SpendController {
    //Recuperar todos os gastos
    //Fazer um crud dos gastos
    
    @Autowired
    private SpendRepository spendRepository;
    
    @GetMapping
    public List<Spend> allSpends(){
        return spendRepository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED )
    public Spend addSpend(@RequestBody Spend spend){
        return spendRepository.save(spend);
    }
    
    //Fazer o READ, UPDATE e DELETE
    
//    @DeleteMapping(path={"/id"})
//    public Spend deleteSpend(Long id){
//        return spendRepository.findById(id)
//                .map(record-> {
//                    spendRepository.deleteById(id);
//                    return Spend;
//                })
//                
//                
//                
//    }
}
