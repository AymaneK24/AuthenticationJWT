package emi.ac.ma.authentification.actorRepositories;

import emi.ac.ma.authentification.Actors.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findByEmail(String email);
    boolean existsByEmail(String email);
}
