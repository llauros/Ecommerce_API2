package com.easymart.controllers;

import com.easymart.models.User;
import com.easymart.parameters.UserParameter;
import com.easymart.presenters.UserPresenter;
import com.easymart.services.UserService;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserPresenter>> findAll() {
        List<User> result = this.service.findAll();

        if (result != null) {

            return new ResponseEntity(result.stream().map(a -> new UserPresenter(a)).collect(Collectors.toList()), HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPresenter> findById(@PathVariable Long id) {
        User result = this.service.findById(id);

        if (result != null) {
            return new ResponseEntity(new UserPresenter(result), HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<UserPresenter> create(@RequestBody UserParameter parameter) {

        if (parameter != null) {
            User model = parameter.toModel();

            return new ResponseEntity(new UserPresenter(this.service.create(model)), HttpStatus.CREATED);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserPresenter> update(@PathVariable Long id, @RequestBody UserParameter parameter) {

        if (parameter != null) {
            User user = parameter.toModel();
            user.setId(id);

            User result = this.service.update(user);

            if (result != null) {
                return new ResponseEntity(new UserPresenter(result), HttpStatus.CREATED);
            } else {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        boolean result = this.service.deleteById(id);

        if (result) {
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
