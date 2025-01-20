package emi.ac.ma.authentification.AuthenticationDoctor.AuthenticationDoctorController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/doctor/auth")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationDoctorController {



    private final AuthenticationDoctorService authenticationDoctorService;


    public AuthenticationDoctorController(AuthenticationDoctorService authenticationDoctorService) {
        this.authenticationDoctorService = authenticationDoctorService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationDoctorResponse> register(
            @RequestBody RegisterDoctorRequest request) {
        return ResponseEntity.ok(authenticationDoctorService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationDoctorResponse> authenticate(
            @RequestBody AuthenticationDoctorRequest request) {
        return ResponseEntity.ok(authenticationDoctorService.authenticate(request));
    }


}
