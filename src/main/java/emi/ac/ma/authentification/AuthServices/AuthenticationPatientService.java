package emi.ac.ma.authentification.AuthServices;



import emi.ac.ma.authentification.AuthenticationResponseAndRequest.AuthenticationPersonneRequest;
import emi.ac.ma.authentification.AuthenticationResponseAndRequest.AuthenticationPersonneResponse;
import emi.ac.ma.authentification.RegisterRequests.RegisterPatientRequest;
import emi.ac.ma.authentification.config.JwtService;

import emi.ac.ma.authentification.Actors.Patient;

import emi.ac.ma.authentification.actorRepositories.PatientRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationPatientService {

    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationPatientService(PatientRepository patientRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.patientRepository = patientRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public AuthenticationPersonneResponse register(RegisterPatientRequest request) {
        if (patientRepository.existsByEmail(request.getEmail())) {

            throw new IllegalArgumentException("Email is already registered");
        }

        Patient patient = new Patient();
        patient.setEmail(request.getEmail());
        patient.setPassword(passwordEncoder.encode(request.getPassword()));
        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setGender(request.getGender());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setRole(request.getRole());


        patientRepository.save(patient);
        var jwtToken = jwtService.generateToken(patient);
        return AuthenticationPersonneResponse.builder().token(jwtToken).build();

    }



    public AuthenticationPersonneResponse authenticate(AuthenticationPersonneRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = patientRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationPersonneResponse.builder().token(jwtToken).build();
    }

}
