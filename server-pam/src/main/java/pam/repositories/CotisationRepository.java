package pam.repositories;

import org.springframework.data.repository.CrudRepository;
import pam.entities.Cotisation;

public interface CotisationRepository extends CrudRepository<Cotisation, Double> {
}
