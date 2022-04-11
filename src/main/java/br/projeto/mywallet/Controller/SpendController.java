package br.projeto.mywallet.Controller;

import br.projeto.mywallet.Model.Spend;
import br.projeto.mywallet.Service.IServiceSpend;

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
    private IServiceSpend spendService;
    
    @GetMapping
    public ResponseEntity allSpends(){
        return ResponseEntity.ok(spendService.getAllSpend());
    }

    @PostMapping
    public ResponseEntity addSpend(@RequestBody Spend spend){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(spendService.addSpend(spend));
    }

    @GetMapping(path={"/{id}"})
    public ResponseEntity readSpend(@PathVariable Long id){
        return ResponseEntity.ok(spendService.getSpend(id));
    }


    @PutMapping(path={"/{id}"})
    public ResponseEntity updateSpend(@PathVariable Long id, @RequestBody Spend spend){
        return ResponseEntity.ok(spendService.updateSpend(id, spend));

    }

    @DeleteMapping(path={"/{id}"})
    public ResponseEntity deleteSpend(@PathVariable Long id){
        return ResponseEntity.ok(spendService.deleteSpend(id));
    }
    
}
