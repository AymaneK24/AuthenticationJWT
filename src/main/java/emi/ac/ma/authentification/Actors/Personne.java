package emi.ac.ma.authentification.Actors;


import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Personne implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;

    public Personne(int id, String firstName, String lastName, String email, String password, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Personne() {
    }

    public static PersonneBuilder builder() {
        return new PersonneBuilder();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(getRole()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
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

    public int getId() {
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

    public String getRole() {
        return this.role;
    }

    public void setId(int id) {
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

    public void setRole(String role) {
        this.role = role;
    }


    public static class PersonneBuilder {
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String role;

        public PersonneBuilder() {
        }

        public PersonneBuilder id(int id) {
            this.id = id;
            return this;
        }

        public PersonneBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonneBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonneBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PersonneBuilder password(String password) {
            this.password = password;
            return this;
        }

        public PersonneBuilder role(String role) {
            this.role = role;
            return this;
        }

        public Personne build() {
            return new Personne(this.id, this.firstName, this.lastName, this.email, this.password, this.role);
        }

    }
}
