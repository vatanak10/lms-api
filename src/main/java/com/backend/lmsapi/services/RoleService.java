package com.backend.lmsapi.services;

import com.backend.lmsapi.model.Role;

public interface RoleService {
    Role addRole(Role role);

    void addRoleToUser(String username, String roleName);
}
