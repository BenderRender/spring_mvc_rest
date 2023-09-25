package ru.kata.spring.boot_security.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public MyUserDetailsService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByName(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = findByName(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User" + username + "not found"));
        }
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getById(id);
    }


    @Override
    @Transactional
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void removeUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(Integer id, User user) {
        Optional<User> userFromDB = userRepository.findById(id);
        String newPassword = user.getPassword();
        String currentPassword = userFromDB.get().getPassword();

        if (!currentPassword.equals(newPassword)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        userRepository.save(user);
    }

    @Override
    @Transactional
    public User convertToUser(UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userDTO, User.class);
    }

}
