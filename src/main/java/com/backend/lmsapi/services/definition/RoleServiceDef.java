package com.backend.lmsapi.services.definition;

import com.backend.lmsapi.model.Role;
import com.backend.lmsapi.model.User;
import com.backend.lmsapi.repositories.RoleRepository;
import com.backend.lmsapi.repositories.UserRepository;
import com.backend.lmsapi.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceDef implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);

        user.getRoles().add(role);
    }
}