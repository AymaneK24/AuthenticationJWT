package emi.ac.ma.authentification.AuthenticationPatient.AuthenticationPatientController;


public class AuthenticationPatientResponse {
    private String token;

    public AuthenticationPatientResponse(String token) {
        this.token = token;
    }

    public AuthenticationPatientResponse() {
    }

    public static AuthenticationResponseBuilder builder() {
        return new AuthenticationResponseBuilder();
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }





    public static class AuthenticationResponseBuilder {
        private String token;

        AuthenticationResponseBuilder() {
        }

        public AuthenticationResponseBuilder token(String token) {
            this.token = token;
            return this;
        }

        public AuthenticationPatientResponse build() {
            return new AuthenticationPatientResponse(this.token);
        }

        public String toString() {
            return "AuthenticationResponse.AuthenticationResponseBuilder(token=" + this.token + ")";
        }
    }
}
