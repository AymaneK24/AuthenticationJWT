package emi.ac.ma.authentification.AuthenticationPatient.AuthenticationPatientController;

import java.util.Date;

public class RegisterPatientRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private Date dateOfBirth;


    public RegisterPatientRequest() {
    }

    public RegisterPatientRequest(String firstName, String lastName, String email, String password, String gender, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public static RegisterPatientRequestBuilder builder() {
        return new RegisterPatientRequestBuilder();
    }


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return this.gender;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public static class RegisterPatientRequestBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String gender;
        private Date dateOfBirth;

        RegisterPatientRequestBuilder() {
        }

        public RegisterPatientRequestBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public RegisterPatientRequestBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public RegisterPatientRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public RegisterPatientRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public RegisterPatientRequestBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public RegisterPatientRequestBuilder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public RegisterPatientRequest build() {
            return new RegisterPatientRequest(this.firstName, this.lastName, this.email, this.password, this.gender, this.dateOfBirth);
        }

        public String toString() {
            return "RegisterPatientRequest.RegisterPatientRequestBuilder(firstName=" + this.firstName + ", lastName=" + this.lastName + ", email=" + this.email + ", password=" + this.password + ", gender=" + this.gender + ", dateOfBirth=" + this.dateOfBirth + ")";
        }
    }



}
