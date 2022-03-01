package com.easymart.services;

import com.easymart.models.User;
import java.util.List;

/**
 * @author lucas
 */
public interface UserService {

    public List<User> findAll();

    public User findById(Long id);

    public User create(User user);

    public User update(User user);

    public boolean deleteById(Long id);
}
