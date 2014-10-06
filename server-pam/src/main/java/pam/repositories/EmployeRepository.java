package pam.repositories;

import org.springframework.data.repository.CrudRepository;
import pam.entities.Employe;

public interface EmployeRepository extends CrudRepository<Employe, Long> {

    // recherche d'un employé via son n° SS
    // Pas besoin d'écrire la req JPQL car générée automatiquement
    public Iterable<Employe> findBySS(String SS);
}
