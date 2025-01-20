package emi.ac.ma.authentification.AuthenticationDoctor.AuthenticationDoctorController;


public class AuthenticationDoctorRequest {

    private String email;
    private String password;



    public AuthenticationDoctorRequest(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public AuthenticationDoctorRequest() {
    }

    public static AuthenticationDoctorRequestBuilder builder() {
        return new AuthenticationDoctorRequestBuilder();
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public static class AuthenticationDoctorRequestBuilder {
        private String email;
        private String password;


        AuthenticationDoctorRequestBuilder() {
        }

        public AuthenticationDoctorRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AuthenticationDoctorRequestBuilder password(String password) {
            this.password = password;
            return this;
        }


        public AuthenticationDoctorRequest build() {
            return new AuthenticationDoctorRequest(this.email, this.password);
        }


    }
}
