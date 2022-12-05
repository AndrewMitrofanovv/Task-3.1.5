package ru.kata.spring.boot_security.demo.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.Services.RoleService;
import ru.kata.spring.boot_security.demo.Services.UserService;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class TestAdminInitialization {


    private final UserService userService;
    private RoleService roleService;


    @Autowired
    public TestAdminInitialization(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleRepository(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostConstruct
    private void createTestAdmin() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("ROLE_ADMIN"));
        roles.add(new Role("ROLE_USER"));
        roleService.saveAll(roles);
        Optional<User> admin = Optional.ofNullable(userService.findUserByEmail("testAdmin@mail.ru"));
        if (admin.isEmpty()) {
            User testAdmin = new User("testAdmin@mail.ru", "testadmin");
            testAdmin.setName("testName");
            testAdmin.setLastName("testLastName");
            testAdmin.setAge((byte) 20);
            testAdmin.setRoles("ROLE_ADMIN");
            userService.saveUser(testAdmin);
        }
    }
}
