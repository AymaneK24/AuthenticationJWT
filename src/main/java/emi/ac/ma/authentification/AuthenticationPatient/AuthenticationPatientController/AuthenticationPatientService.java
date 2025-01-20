package emi.ac.ma.authentification.AuthenticationPatient.AuthenticationPatientController;



import emi.ac.ma.authentification.config.JwtService;

import emi.ac.ma.authentification.AuthenticationPatient.patient.Patient;

import emi.ac.ma.authentification.AuthenticationPatient.patient.PatientRepository;
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


    public AuthenticationPatientResponse register(RegisterPatientRequest request) {
        if (patientRepository.existsByEmail(request.getEmail())) {

            throw new IllegalArgumentException("Email is already registered");
        }

        Patient patient = new Patient.PatientBuilder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .dateOfBirth(request.getDateOfBirth())
                .gender(request.getGender())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        patientRepository.save(patient);
        var jwtToken = jwtService.generateToken(patient);
        return AuthenticationPatientResponse.builder().token(jwtToken).build();

    }



    public AuthenticationPatientResponse authenticate(AuthenticationPatientRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = patientRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationPatientResponse.builder().token(jwtToken).build();
    }

}
