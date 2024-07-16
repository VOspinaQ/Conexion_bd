package co.com.ps.c24a.service;

import co.com.ps.c24a.entity.Person;
import co.com.ps.c24a.repository.PersonRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Tag(name = "Person API", description = "API for managing persons")
@Service
@RequiredArgsConstructor
public class PersonServiceImp  implements PersonService{

    private final PersonRepository personRepository;

    @Override
    public Optional<Person> getPersonById(Long id) {
        return Optional.ofNullable(personRepository.findById(id).orElseThrow(()-> new RuntimeException("No encontro registro")));
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        if (!personRepository.existById(person.getId())) {
            throw new RuntimeException("No encontre esa persona");
        }
        person.setId(id);

        return personRepository.save(person);
    }


    @Override
    public void deletePerson(Long id) {
        if (!personRepository.existById(id)) {
            throw new RuntimeException("No encontre esa persona");
        }
        personRepository.deleteById(id);
    }

    public List<Person> getPersonAll() {
        List<Person> tmp = new ArrayList<>();
        personRepository.findAll().forEach(tmp::add);
        return tmp;
    }
}







