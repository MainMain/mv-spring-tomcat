package pam.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pam.entities.Employe;

import java.util.List;

public interface EmployeRepository extends CrudRepository<Employe, Long> {

    // recherche d'un employé via son n° SS
    @Query("select e from Employe e left join fetch e.indemnite i where e.SS=?1 and e.idIndemnite=i.id")
    public List<Employe> findBySS(String SS);
}
