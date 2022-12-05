package ru.kata.spring.boot_security.demo.Services;

import ru.kata.spring.boot_security.demo.models.User;

public interface UserService {

    User findUserByEmail(String email);

    User findUserById(Long id);

    void deleteUser(Long id);

    void saveUser(User user);

    void updateUser(User updateUser);

    Iterable<User> getAllUsers();
}
