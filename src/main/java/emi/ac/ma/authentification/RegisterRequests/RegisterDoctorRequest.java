package emi.ac.ma.authentification.RegisterRequests;


public class RegisterDoctorRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Long inpe;
    private String description;
    private String specialty;
    private String telephone;
    private String langue;
    private String genreConsultation;
    private String prixConsultation;
    private String role;

    public RegisterDoctorRequest(String firstname, String lastname, String email, String password, Long inpe, String description, String specialty, String telephone, String langue, String genreConsultation, String prixConsultation) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.inpe = inpe;
        this.description = description;
        this.specialty = specialty;
        this.telephone = telephone;
        this.langue = langue;
        this.genreConsultation = genreConsultation;
        this.prixConsultation = prixConsultation;
        setRole("DOCTOR");
    }

    public RegisterDoctorRequest() {
        setRole("DOCTOR");
    }


    public static RegisterDoctorRequestBuilder builder() {
        return new RegisterDoctorRequestBuilder();
    }


    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
    public String getRole() {
        return this.role;
    }


    public Long getInpe() {
        return this.inpe;
    }

    public String getDescription() {
        return this.description;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public String getLangue() {
        return this.langue;
    }

    public String getGenreConsultation() {
        return this.genreConsultation;
    }

    public String getPrixConsultation() {
        return this.prixConsultation;
    }

    public void setInpe(Long inpe) {
        this.inpe = inpe;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public void setGenreConsultation(String genreConsultation) {
        this.genreConsultation = genreConsultation;
    }

    public void setPrixConsultation(String prixConsultation) {
        this.prixConsultation = prixConsultation;
    }

    public static class RegisterDoctorRequestBuilder {
        private String firstname;
        private String lastname;
        private String email;
        private String password;
        private Long inpe;
        private String description;
        private String specialty;
        private String telephone;
        private String langue;
        private String genreConsultation;
        private String prixConsultation;

        RegisterDoctorRequestBuilder() {
        }

        public RegisterDoctorRequestBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public RegisterDoctorRequestBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public RegisterDoctorRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public RegisterDoctorRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public RegisterDoctorRequestBuilder inpe(Long inpe) {
            this.inpe = inpe;
            return this;
        }

        public RegisterDoctorRequestBuilder description(String description) {
            this.description = description;
            return this;
        }

        public RegisterDoctorRequestBuilder specialty(String specialty) {
            this.specialty = specialty;
            return this;
        }

        public RegisterDoctorRequestBuilder telephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public RegisterDoctorRequestBuilder langue(String langue) {
            this.langue = langue;
            return this;
        }

        public RegisterDoctorRequestBuilder genreConsultation(String genreConsultation) {
            this.genreConsultation = genreConsultation;
            return this;
        }

        public RegisterDoctorRequestBuilder prixConsultation(String prixConsultation) {
            this.prixConsultation = prixConsultation;
            return this;
        }

        public RegisterDoctorRequest build() {
            return new RegisterDoctorRequest(this.firstname, this.lastname, this.email, this.password, this.inpe, this.description, this.specialty, this.telephone, this.langue, this.genreConsultation, this.prixConsultation);
        }

    }
}
