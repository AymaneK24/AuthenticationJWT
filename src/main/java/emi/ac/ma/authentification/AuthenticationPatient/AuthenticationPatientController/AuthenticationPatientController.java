package emi.ac.ma.authentification.AuthenticationPatient.AuthenticationPatientController;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationPatientController {

    private final AuthenticationPatientService authenticationService;

    public AuthenticationPatientController(AuthenticationPatientService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationPatientResponse> register(
            @RequestBody RegisterPatientRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationPatientResponse> authenticate(
            @RequestBody AuthenticationPatientRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }



}
