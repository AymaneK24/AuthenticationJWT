package emi.ac.ma.authentification.actorRepositories;

import emi.ac.ma.authentification.Actors.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {
    boolean existsByEmail(String email);
    Optional<Personne> findByEmail(String email);
}
