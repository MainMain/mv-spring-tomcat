package pam.repositories;

import org.springframework.data.repository.CrudRepository;
import pam.entities.Employe;

import java.util.List;

public interface EmployeRepository extends CrudRepository<Employe, Double> {

    // recherche d'un employé via son n° SS
    public Iterable<Employe> findBySS(String SS);
}
