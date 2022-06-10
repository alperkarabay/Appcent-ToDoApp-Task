/*package com.appcenttodo.SpringSecurityBasicAuth;


import java.util.Set;

import com.appcenttodo.models.Role;
import com.appcenttodo.models.UserDetail;
import com.appcenttodo.repositories.RoleRepository;
import com.appcenttodo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // Create user roles
        var userRole = createRoleIfNotFound(Role.ROLE_USER);
        var adminRole = createRoleIfNotFound(Role.ROLE_ADMIN);

        // Create users
        createUserIfNotFound("user", userRole);
        createUserIfNotFound("admin", adminRole);

        alreadySetup = true;
    }

    @Transactional
    private final Role createRoleIfNotFound(final String name) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role = roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    private final UserDetail createUserIfNotFound(final String name, final Role role) {
        UserDetail user = userRepository.findByUsername(name);
        if (user == null) {
            user = new UserDetail(name, "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6") {
            };
            user.setRoles(Set.of(role));
            user = userRepository.save(user);
        }
        return user;
    }
}*/