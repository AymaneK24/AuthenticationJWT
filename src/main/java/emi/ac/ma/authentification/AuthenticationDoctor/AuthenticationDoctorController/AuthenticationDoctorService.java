package emi.ac.ma.authentification.AuthenticationDoctor.AuthenticationDoctorController;


import emi.ac.ma.authentification.AuthenticationDoctor.doctor.Doctor;
import emi.ac.ma.authentification.AuthenticationDoctor.doctor.DoctorRepository;
import emi.ac.ma.authentification.config.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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


    public AuthenticationDoctorResponse register(RegisterDoctorRequest request) {
        if (doctorRepository.existsByEmail(request.getEmail())) {

            throw new IllegalArgumentException("Email is already registered");
        }

        Doctor doctor = new Doctor.DoctorBuilder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .telephone(request.getTelephone())
                .specialty(request.getSpecialty())
                .description(request.getDescription())
                .langue(request.getLangue())
                .inpe(request.getInpe())
                .prixConsultation(request.getPrixConsultation())
                .genreConsultation(request.getGenreConsultation())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        doctorRepository.save(doctor);
        var jwtToken = jwtService.generateToken(doctor);
        return AuthenticationDoctorResponse.builder().token(jwtToken).build();

    }



    public AuthenticationDoctorResponse authenticate(AuthenticationDoctorRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = doctorRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationDoctorResponse.builder().token(jwtToken).build();
    }

}
