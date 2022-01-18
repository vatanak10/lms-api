package com.backend.lmsapi.services;

import java.util.List;

import com.backend.lmsapi.model.Role;

public interface RoleService {

    List<Role> getAllRoles();

    Role addRole(Role role);

    void addRoleToUser(String username, String roleName);
}
