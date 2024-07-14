package br.projeto.mywallet.Controller;

import br.projeto.mywallet.DTO.PersonDTO;
import br.projeto.mywallet.DTO.WalletDTO;
import br.projeto.mywallet.Model.Person;
import br.projeto.mywallet.Service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/person")
@CrossOrigin
public class PersonController {
    
    @Autowired
    private IPersonService personService;
    
    @GetMapping(path = "/{id}")
    public ResponseEntity getPerson(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(personService.getPerson(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getAllPerson() {
        return ResponseEntity.ok(personService.getAllPerson());
    }

    @PostMapping
    public ResponseEntity createPerson(@RequestBody PersonDTO personDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personService.createPerson(personDTO));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        try {
            return ResponseEntity.ok(personService.updatePerson(id, personDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }
}
