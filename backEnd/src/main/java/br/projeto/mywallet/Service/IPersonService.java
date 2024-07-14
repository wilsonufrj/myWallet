package br.projeto.mywallet.Service;

import br.projeto.mywallet.DTO.PersonDTO;
import java.util.List;

/**
 *
 * @author wilson
 */
public interface IPersonService {
    public PersonDTO createPerson(PersonDTO personDTO);
    public List<PersonDTO> getAllPerson();
    public PersonDTO getPerson(Long id) throws Exception;
    public PersonDTO updatePerson(Long id, PersonDTO personDTO) throws Exception;
    public void deletePerson(Long id);
}
