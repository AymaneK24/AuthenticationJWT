package emi.ac.ma.authentification.AuthServices;


import emi.ac.ma.authentification.Actors.Doctor;
import emi.ac.ma.authentification.Actors.Personne;
import emi.ac.ma.authentification.RegisterRequests.RegisterDoctorRequest;
import emi.ac.ma.authentification.AuthenticationResponseAndRequest.AuthenticationPersonneRequest;
import emi.ac.ma.authentification.AuthenticationResponseAndRequest.AuthenticationPersonneResponse;
import emi.ac.ma.authentification.actorRepositories.DoctorRepository;
import emi.ac.ma.authentification.config.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationDoctorService {

    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationDoctorService(DoctorRepository doctorRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public AuthenticationPersonneResponse register(RegisterDoctorRequest request) {
        if (doctorRepository.existsByEmail(request.getEmail())) {

            throw new IllegalArgumentException("Email is already registered");
        }

        Doctor doctor = new Doctor();
        doctor.setFirstName(request.getFirstname());
        doctor.setLastName(request.getLastname());
        doctor.setEmail(request.getEmail());
        doctor.setTelephone(request.getTelephone());
        doctor.setSpecialty(request.getSpecialty());
        doctor.setDescription(request.getDescription());
        doctor.setLangue(request.getLangue());
        doctor.setInpe(request.getInpe());
        doctor.setPrixConsultation(request.getPrixConsultation());
        doctor.setGenreConsultation(request.getGenreConsultation());
        doctor.setPassword(passwordEncoder.encode(request.getPassword()));
        doctor.setRole(request.getRole());




        doctorRepository.save(doctor);
        var jwtToken = jwtService.generateToken(doctor);
        return AuthenticationPersonneResponse.builder().token(jwtToken).build();

    }



    public AuthenticationPersonneResponse authenticate(AuthenticationPersonneRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = doctorRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationPersonneResponse.builder().token(jwtToken).build();
    }

}
