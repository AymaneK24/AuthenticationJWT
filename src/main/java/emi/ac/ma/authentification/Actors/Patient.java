package emi.ac.ma.authentification.Actors;


import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Date;


@Entity
@Table(name = "PATIENT")
public class Patient extends Personne implements UserDetails {

    @MapsId
    private int id;



    private String gender;

    @NotNull
    private Date dateOfBirth;

    public Patient(){
        super();
        setRole("PATIENT");
    }





    public Patient(String gender,Date dateOfBirth) {
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        setRole("PATIENT");
    }

    public static PatientBuilder builder() {
        return new PatientBuilder();
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

    public static class PatientBuilder extends PersonneBuilder {
        private int id;
        private String gender;
        private Date dateOfBirth;

        public PatientBuilder() {

        }

        public PatientBuilder id(int id) {
            this.id = id;
            return this;
        }

        public PatientBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public PatientBuilder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Patient build() {
            return new Patient(this.gender, this.dateOfBirth);
        }

    }
}
