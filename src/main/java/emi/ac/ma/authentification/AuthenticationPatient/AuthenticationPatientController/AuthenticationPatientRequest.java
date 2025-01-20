package emi.ac.ma.authentification.AuthenticationPatient.AuthenticationPatientController;

public class AuthenticationPatientRequest {
    private String email;
    private String password;



    public AuthenticationPatientRequest() {
    }

    public AuthenticationPatientRequest(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public static AuthenticationRequestBuilder builder() {
        return new AuthenticationRequestBuilder();
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





    public static class AuthenticationRequestBuilder {
        private String email;
        private String password;


        AuthenticationRequestBuilder() {
        }

        public AuthenticationRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AuthenticationRequestBuilder password(String password) {
            this.password = password;
            return this;
        }



        public AuthenticationPatientRequest build() {
            return new AuthenticationPatientRequest(this.email, this.password);
        }


    }
}
