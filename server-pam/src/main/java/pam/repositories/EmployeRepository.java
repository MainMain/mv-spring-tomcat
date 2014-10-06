package pam.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pam.entities.Employe;

import java.util.List;

public interface EmployeRepository extends CrudRepository<Employe, Long> {

    // recherche d'un employé via son n° SS
    // Pas besoin d'écrire la req JPQL car générée automatiquement
    @Query("select e from Employe e where e.SS=?1")
    public List<Employe> findBySS(String SS);
}
