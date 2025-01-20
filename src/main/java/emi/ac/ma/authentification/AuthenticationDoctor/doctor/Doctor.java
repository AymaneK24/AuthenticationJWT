package emi.ac.ma.authentification.AuthenticationDoctor.doctor;


import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "DOCTOR")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Doctor implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long   inpe;
    private String description;
    private String specialty;
    private String telephone;
    private String langue;
    private String genreConsultation;
    private String prixConsultation;


    public Doctor() {
    }

    public Doctor(Integer id, String firstName, String lastName, String email, String password, Long inpe, String description, String specialty, String telephone, String langue, String genreConsultation, String prixConsultation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.inpe = inpe;
        this.description = description;
        this.specialty = specialty;
        this.telephone = telephone;
        this.langue = langue;
        this.genreConsultation = genreConsultation;
        this.prixConsultation = prixConsultation;
    }

    public static DoctorBuilder builder() {
        return new DoctorBuilder();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("DOCTOR"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getId() {
        return this.id;
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


    public void setId(Integer id) {
        this.id = id;
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






    public static class DoctorBuilder {
        private Integer id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private Long inpe;
        private String description;
        private String specialty;
        private String telephone;
        private String langue;
        private String genreConsultation;
        private String prixConsultation;

        public DoctorBuilder() {
        }

        public DoctorBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public DoctorBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public DoctorBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public DoctorBuilder email(String email) {
            this.email = email;
            return this;
        }

        public DoctorBuilder password(String password) {
            this.password = password;
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
            return new Doctor(this.id, this.firstName, this.lastName, this.email, this.password, this.inpe, this.description, this.specialty, this.telephone, this.langue, this.genreConsultation, this.prixConsultation);
        }


    }
}
