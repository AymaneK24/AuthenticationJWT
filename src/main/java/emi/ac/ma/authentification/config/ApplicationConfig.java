package emi.ac.ma.authentification.config;



import emi.ac.ma.authentification.Actors.Personne;
import emi.ac.ma.authentification.actorRepositories.DoctorRepository;
import emi.ac.ma.authentification.actorRepositories.PatientRepository;
import emi.ac.ma.authentification.actorRepositories.PersonneRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

    private final PersonneRepository personneRepository ;
    private final PatientRepository patientRepository ;
    private final DoctorRepository doctorRepository ;

    public ApplicationConfig(PersonneRepository personneRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.personneRepository = personneRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            System.out.println("Recherche de l'utilisateur avec l'email : " + username);


            Personne personne = personneRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

            // Check the user's role and fetch the corresponding entity
            return switch (personne.getRole()) {
                case "PATIENT" -> patientRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Patient not found with email: " + username));
                case "DOCTOR" -> doctorRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Doctor not found with email: " + username));
                default -> throw new UsernameNotFoundException("Unknown role for user with email: " + username);
            };
        };
    }



    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
