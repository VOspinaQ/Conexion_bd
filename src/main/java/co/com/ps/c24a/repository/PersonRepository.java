package co.com.ps.c24a.repository;

import co.com.ps.c24a.Person;
import co.com.ps.c24a.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long>{
}
