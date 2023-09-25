package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer id);

    void addUser(User user);

    void removeUser(Integer id);

    void updateUser(Integer id, User user);

    Optional<User> findByName(String username);

    User convertToUser(UserDTO userDto);
}
