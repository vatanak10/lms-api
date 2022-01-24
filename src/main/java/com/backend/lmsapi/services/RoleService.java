package com.backend.lmsapi.services;

import java.util.List;

import com.backend.lmsapi.model.Role;
import com.backend.lmsapi.model.User;

public interface RoleService {

    List<Role> getAllRoles();

    Role addRole(Role role);

    User addRoleToUser(String username, String roleName);
}
