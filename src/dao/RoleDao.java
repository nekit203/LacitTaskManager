package dao;

import java.util.List;

import entity.Role;

public interface RoleDao extends CrudDao<Long, Role> {
    
    List<Role> findAll();

    Role findByName(String name);
    
    void addUserRoles(Long uid);
    
    void deleteUserRoles(Long id);
}