package com.easymart.parameters;

import com.easymart.models.User;

/**
 * @author lucas
 */
public class UserParameter {

    private String name;
    private String email;
    private String password;
    private String phone;

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

        model.setName(this.name);
        model.setEmail(this.email);
        model.setPassword(this.password);
        model.setPhone(this.phone);
        
        return model;
    }

}
