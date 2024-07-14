package br.projeto.mywallet.ServiceImpl;

import br.projeto.mywallet.DTO.PersonDTO;
import br.projeto.mywallet.Model.Person;
import br.projeto.mywallet.Service.IPersonService;
import br.projeto.mywallet.repository.PersonRepository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author wilson
 */
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = new Person(
                personDTO.getName()
        );

        try {
            return this.getPerson(personRepository.save(person).getId());
        } catch (Exception ex) {
            Logger.getLogger(PersonService.class.getName()).log(Level.SEVERE, "Erro to adding Person", ex);
        }
        return null;
    }

    @Override
    public List<PersonDTO> getAllPerson() {
        return personRepository.findAll()
                .stream()
                .map(person -> person.converteToDto())
                .toList();
    }

    @Override
    public PersonDTO getPerson(Long id) throws Exception {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new Exception("Person was not found"));

        return person.converteToDto();
    }

    @Override
    public PersonDTO updatePerson(Long id, PersonDTO personDTO) throws Exception {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new Exception("Person was not found"));

        person.setName(personDTO.getName());
        return this.getPerson(personRepository.save(person).getId());
    }

    @Override
    public void deletePerson(Long id) {
        this.personRepository.deleteById(id);
    }

}
