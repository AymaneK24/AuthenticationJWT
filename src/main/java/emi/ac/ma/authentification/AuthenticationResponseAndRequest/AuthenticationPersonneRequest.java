package emi.ac.ma.authentification.AuthenticationResponseAndRequest;


public class AuthenticationPersonneRequest {
    private String email;
    private String password;
    private String role;


    public AuthenticationPersonneRequest() {
    }

    public AuthenticationPersonneRequest(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;

    }

    public static AuthenticationPersonneRequestBuilder builder() {
        return new AuthenticationPersonneRequestBuilder();
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRole() {
        return this.role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }






    public static class AuthenticationPersonneRequestBuilder {
        private String email;
        private String password;
        private String role;

        public AuthenticationPersonneRequestBuilder() {
        }

        public AuthenticationPersonneRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AuthenticationPersonneRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public AuthenticationPersonneRequestBuilder role(String role) {
            this.role = role;
            return this;
        }

        public AuthenticationPersonneRequest build() {
            return new AuthenticationPersonneRequest(this.email, this.password, this.role);
        }


    }
}
