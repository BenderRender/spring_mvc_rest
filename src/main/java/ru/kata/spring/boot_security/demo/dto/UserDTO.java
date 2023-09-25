package ru.kata.spring.boot_security.demo.dto;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Objects;
import java.util.Set;

public class UserDTO {
    private Integer id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String password;
    private Set<Role> roles;

    public UserDTO() {
    }

    public UserDTO(Integer id, String name, String surname, Integer age, String email, String password, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.password = password;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDto = (UserDTO) o;
        return age == userDto.age && Objects.equals(id, userDto.id) && Objects.equals(name, userDto.name) && Objects.equals(surname, userDto.surname) && Objects.equals(email, userDto.email) && Objects.equals(password, userDto.password) && Objects.equals(roles, userDto.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, password, roles);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
