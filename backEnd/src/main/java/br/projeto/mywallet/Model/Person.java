package br.projeto.mywallet.Model;

import br.projeto.mywallet.DTO.PersonDTO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
/**
 *
 * @author wilson
 */

@Entity
@Table(name = "persons")
public class Person implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + '}';
    }
    
    public PersonDTO converteToDto() {
        return new PersonDTO(
                this.getId(),
                this.getName()
        );
    }
}
