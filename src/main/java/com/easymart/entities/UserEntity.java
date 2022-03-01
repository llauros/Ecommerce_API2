package com.easymart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.easymart.models.User;

@Entity
@Table(name = "tb_usuario")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome não pode estar em branco ou ser nulo")
    @Size(min = 3, max = 100, message = "O campo nome não pode conter menos que {min} e não deve ultrapassar a {max} caracteres")
    @Column(name = "nome", length = 100)
    private String name;

    @NotBlank(message = "O campo nome não pode estar em branco ou ser nulo")
    @Email(message = "Email invalido")
    @Column(name = "emai")
    private String email;

    @Column(name = "telefone")
    private String phone;

    @Column(name = "senha")
    private String password;

    public UserEntity() {}
    
    public UserEntity(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
	
    public UserEntity(User model) {
        this.name = model.getName();
        this.email = model.getEmail();
        this.password = model.getPassword();
        this.phone = model.getPhone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toModel() {
        User model = new User();

        model.setId(this.id);
        model.setName(this.name);
        model.setEmail(this.email);
        model.setPassword(this.password);
        model.setPhone(this.phone);

        return model;
    }
}
