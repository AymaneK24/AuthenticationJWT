package emi.ac.ma.authentification.AuthenticationResponseAndRequest;


public class AuthenticationPersonneResponse {
    private String token;

    public AuthenticationPersonneResponse(String token) {
        this.token = token;
    }

    public AuthenticationPersonneResponse() {
    }

    public static AuthenticationPersonneResponseBuilder builder() {
        return new AuthenticationPersonneResponseBuilder();
    }


    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public static class AuthenticationPersonneResponseBuilder {
        private String token;

        AuthenticationPersonneResponseBuilder() {
        }

        public AuthenticationPersonneResponseBuilder token(String token) {
            this.token = token;
            return this;
        }

        public AuthenticationPersonneResponse build() {
            return new AuthenticationPersonneResponse(this.token);
        }


    }
}
