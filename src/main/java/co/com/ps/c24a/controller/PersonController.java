package co.com.ps.c24a.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

@PostMapping
    public Person savePerson(@RequestBody Person person) {
    return personService.savePerson(person);
}

@GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id){
    return personService.getPersonById(id).orElseThrow(()-> new RuntimeException("No encontro el Id"));

}
@PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person){
    return personService.updatePerson(id,person);

}
@DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
    personService.deletePerson(id);
}
@GetMapping()
    public List<Person> getPerson(){
        return personService.getPersonAll();
}


}
