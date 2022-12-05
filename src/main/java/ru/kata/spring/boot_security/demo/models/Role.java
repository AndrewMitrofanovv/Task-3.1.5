package ru.kata.spring.boot_security.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import java.util.Set;

@Entity
@Table(name = "t_roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "role")
    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(String name) {
        if (name.contains("ROLE_ADMIN")) {
            this.id = 1L;
        } else if (name.contains("ROLE_USER")) {
            this.id = 2L;
        }
        this.name = name;
    }


    public Role() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String role) {
        this.name = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    @JsonIgnore
    @Override
    public String getAuthority() {
        return getName();
    }


    @Override
    public String toString() {
        return name.substring(name.lastIndexOf('_') + 1);
    }
}

