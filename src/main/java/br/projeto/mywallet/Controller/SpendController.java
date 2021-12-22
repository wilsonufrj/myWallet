package br.projeto.mywallet.Controller;

import br.projeto.mywallet.Model.Spend;
import br.projeto.mywallet.repository.SpendRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wilson
 */

@RestController
@RequestMapping("/spend")
public class SpendController {
    
    @Autowired
    private SpendRepository spendRepository;
    
    @GetMapping
    public List<Spend> allSpends(){
        return spendRepository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Spend> addSpend(@RequestBody Spend spend){
        Spend spendAux =  spendRepository.save(spend);
        return ResponseEntity.status(HttpStatus.CREATED).body(spendAux);
    }
    
    
    //Rever essa resposta caso o id não seja achado
    @GetMapping(path={"/{id}"})
    public ResponseEntity<Spend> readSpend(@PathVariable Long id){
        return spendRepository.findById(id)
                .map(spend ->ResponseEntity.ok().body(spend))
                .orElse(ResponseEntity.notFound().build());
    }
    
    
    @PutMapping(path={"/{id}"}) //Fazer algumas validaçoes
    public ResponseEntity<Spend> updateSpend(@PathVariable Long id, @RequestBody Spend spend){
        return spendRepository.findById(id)
                .map(spendFounded->{
                    spendFounded.setValue(spend.getValue());
                    spendFounded.setDay(spend.getDay());
                    spendFounded.setLocation(spend.getLocation());
                    spendFounded.setDescription(spend.getDescription());
                    spendFounded.setItMonthly(spend.isItMonthly());
                    Spend updated = spendRepository.save(spendFounded);
                    
                    
                   return ResponseEntity.status(HttpStatus.CREATED).body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
                
    }
    
    @DeleteMapping(path={"/{id}"})
    public ResponseEntity deleteSpend(@PathVariable Long id){
        return spendRepository.findById(id)
                .map(spendFounded-> {
                    spendRepository.delete(spendFounded);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
}
