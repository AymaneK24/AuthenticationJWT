package emi.ac.ma.authentification.Actors;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import org.springframework.security.core.userdetails.UserDetails;

@Table(name = "DOCTOR")
@Entity

public class Doctor extends Personne implements UserDetails {

    @MapsId
    private int id;

    @Column(unique = true)
    private Long inpe;
    private String description;
    private String specialty;
    private String telephone;
    private String langue;
    private String genreConsultation;
    private String prixConsultation;



    public Doctor(int id, Long inpe, String description, String specialty, String telephone, String langue, String genreConsultation, String prixConsultation) {
        this.id = id;
        this.inpe = inpe;
        this.description = description;
        this.specialty = specialty;
        this.telephone = telephone;
        this.langue = langue;
        this.genreConsultation = genreConsultation;
        this.prixConsultation = prixConsultation;
        setRole("DOCTOR");
    }

    public Doctor() {
        setRole("DOCTOR");
    }

    public int getId() {
        return this.id;
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

    public void setId(int id) {
        this.id = id;
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

    public static DoctorBuilder builder() {
        return new DoctorBuilder();
    }


    public static class DoctorBuilder  extends PersonneBuilder {

        private int id;
        private Long inpe;
        private String description;
        private String specialty;
        private String telephone;
        private String langue;
        private String genreConsultation;
        private String prixConsultation;

        public DoctorBuilder() {
        }

        public DoctorBuilder id(int id) {
            this.id = id;
            return this;
        }

        public DoctorBuilder inpe(Long inpe) {
            this.inpe = inpe;
            return this;
        }

        public DoctorBuilder description(String description) {
            this.description = description;
            return this;
        }

        public DoctorBuilder specialty(String specialty) {
            this.specialty = specialty;
            return this;
        }

        public DoctorBuilder telephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public DoctorBuilder langue(String langue) {
            this.langue = langue;
            return this;
        }

        public DoctorBuilder genreConsultation(String genreConsultation) {
            this.genreConsultation = genreConsultation;
            return this;
        }

        public DoctorBuilder prixConsultation(String prixConsultation) {
            this.prixConsultation = prixConsultation;
            return this;
        }

        public Doctor build() {

            return new Doctor(this.id, this.inpe, this.description, this.specialty, this.telephone, this.langue, this.genreConsultation, this.prixConsultation);
        }




    }
}

