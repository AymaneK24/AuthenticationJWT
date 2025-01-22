package emi.ac.ma.authentification.actorRepositories;


import emi.ac.ma.authentification.Actors.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    Optional<Doctor> findByEmail(String email);
    boolean existsByEmail(String email);
}
