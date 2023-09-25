package ru.kata.spring.boot_security.demo.dbinit;


import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.MyUserDetailsService;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;


import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DatabaseInit {
    private final MyUserDetailsService userService;
    private final RoleServiceImpl roleService;

    public DatabaseInit(MyUserDetailsService userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @PostConstruct
    private void postConstruct() {
        Role roleAdmin = new Role(1,"USER");
        Role roleUser = new Role( 2,"ADMIN");
        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        User user = new User( "user", "user", 1, "user@mail.ru", "user", Set.of(roleUser));
        User admin = new User( "admin","admin", 2,"admin@mail.ru", "admin", Set.of(roleAdmin, roleUser));
        userService.addUser(user);
        userService.addUser(admin);
    }
}