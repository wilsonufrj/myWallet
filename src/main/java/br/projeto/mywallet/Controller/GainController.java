package br.projeto.mywallet.Controller;

import br.projeto.mywallet.Model.Gain;
import br.projeto.mywallet.repository.GainRepository;
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
@RequestMapping("/gain")
public class GainController {
    
    @Autowired
    private GainRepository gainRepository;
    
    @GetMapping
    public List<Gain> allGain(){
        return gainRepository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Gain> addGain(@RequestBody Gain gain){
        Gain gainAux = gainRepository.save(gain);
        return ResponseEntity.status(HttpStatus.CREATED).body(gainAux);
    }
    
    @GetMapping(path={"/{id}"})
    public ResponseEntity<Gain> readGain(@PathVariable Long id){
        return gainRepository.findById(id)
                .map(gainFound -> ResponseEntity.ok().body(gainFound))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping(path={"/{id}"})
    public ResponseEntity<Gain> updateGain(@PathVariable Long id,@RequestBody Gain gain){
        return gainRepository.findById(id)
                .map(gainFound ->{
                    gainFound.setValue(gain.getValue());
                    gainFound.setDay(gain.getDay());
                    gainFound.setDescription(gain.getDescription());
                    gainFound.setItMonthly(gain.isItMonthly());
                    
                    Gain update = gainRepository.save(gainFound);
                    
                    return ResponseEntity.ok().body(update);
                    
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(path={"/{id}"})
    public ResponseEntity deleteGain(@PathVariable Long id){
        return gainRepository.findById(id)
                .map(gainFound->{
                    gainRepository.delete(gainFound);
                    return ResponseEntity.ok().body("Ganho excluido");
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
}
