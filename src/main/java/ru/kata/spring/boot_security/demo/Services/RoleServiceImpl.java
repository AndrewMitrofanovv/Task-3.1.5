package ru.kata.spring.boot_security.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.Repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.models.Role;


import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Transactional
    @Override
    public Set<Role> getAllRoles() {
        Iterable<Role>  iterable = roleRepository.findAll();
        Set<Role> set = new HashSet<>();
        iterable.forEach(set::add);
        return set;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
    @Transactional
    @Override
    public void saveAll(Set<Role> roles) {
        roleRepository.saveAll(roles);
    }
    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }

}
