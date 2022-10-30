package com.demo.northwind.core.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "email")
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Column(name = "password")
    @NotNull
    @NotBlank
    private String password;

    public User(){

    }

    public User(int _id, String _email, String _password){
        this.setId(_id);
        this.setEmail(_email);
        this.setPassword(_password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
