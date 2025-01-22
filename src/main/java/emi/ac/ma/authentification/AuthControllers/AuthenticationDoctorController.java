package emi.ac.ma.authentification.AuthControllers;

import emi.ac.ma.authentification.AuthServices.AuthenticationDoctorService;
import emi.ac.ma.authentification.AuthenticationResponseAndRequest.AuthenticationPersonneRequest;
import emi.ac.ma.authentification.RegisterRequests.RegisterDoctorRequest;
import emi.ac.ma.authentification.AuthenticationResponseAndRequest.AuthenticationPersonneResponse;
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
    public ResponseEntity<AuthenticationPersonneResponse> register(
            @RequestBody RegisterDoctorRequest request) {
        return ResponseEntity.ok(authenticationDoctorService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationPersonneResponse> authenticate(
            @RequestBody AuthenticationPersonneRequest request) {
        return ResponseEntity.ok(authenticationDoctorService.authenticate(request));
    }


}
