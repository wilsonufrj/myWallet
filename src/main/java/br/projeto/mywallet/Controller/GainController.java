package br.projeto.mywallet.Controller;

import br.projeto.mywallet.Model.Gain;
import br.projeto.mywallet.Service.IServiceGain;

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
    private IServiceGain gainService;
    
    @GetMapping
    public ResponseEntity allGain(){
        return ResponseEntity.ok(gainService.allGain());
    }
    
    @PostMapping
    public ResponseEntity addGain(@RequestBody Gain gain){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(gainService.addGain(gain));
    }
    
    @GetMapping(path={"/{id}"})
    public ResponseEntity readGain(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(gainService.readGain(id));
    }
    
    @PutMapping(path={"/{id}"})
    public ResponseEntity updateGain(@PathVariable Long id,@RequestBody Gain gain){
        return ResponseEntity.ok(gainService.updateGain(id,gain));
    }
    
    @DeleteMapping(path={"/{id}"})
    public ResponseEntity deleteGain(@PathVariable Long id){
        return ResponseEntity.ok(gainService.deleteGain(id));
    }
    
}
