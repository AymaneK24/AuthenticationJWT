package emi.ac.ma.authentification.AuthenticationDoctor.AuthenticationDoctorController;

public class AuthenticationDoctorResponse {
    private String token;

    public AuthenticationDoctorResponse(String token) {
        this.token = token;

    }

    public AuthenticationDoctorResponse() {
    }

    public static AuthenticationDoctorResponseBuilder builder() {
        return new AuthenticationDoctorResponseBuilder();
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class AuthenticationDoctorResponseBuilder {
        private String token;


        AuthenticationDoctorResponseBuilder() {
        }

        public AuthenticationDoctorResponseBuilder token(String token) {
            this.token = token;
            return this;
        }


        public AuthenticationDoctorResponse build() {
            return new AuthenticationDoctorResponse(this.token);
        }

        public String toString() {
            return "AuthenticationDoctorResponse.AuthenticationDoctorResponseBuilder(token=" + this.token + ")";
        }
    }
}
