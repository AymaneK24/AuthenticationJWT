package emi.ac.ma.authentification.AuthControllers;


import emi.ac.ma.authentification.AuthenticationResponseAndRequest.AuthenticationPersonneRequest;
import emi.ac.ma.authentification.AuthenticationResponseAndRequest.AuthenticationPersonneResponse;
import emi.ac.ma.authentification.AuthServices.AuthenticationPatientService;
import emi.ac.ma.authentification.RegisterRequests.RegisterPatientRequest;
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
    public ResponseEntity<AuthenticationPersonneResponse> register(
            @RequestBody RegisterPatientRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationPersonneResponse> authenticate(
            @RequestBody AuthenticationPersonneRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }



}
