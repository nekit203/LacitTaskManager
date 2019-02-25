package dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import dao.RoleDao;
import entity.Role;

public class RoleMapper extends SqlSessionDaoSupport implements RoleDao {

    public void create(Role obj) {
        getSqlSession().insert("Role.create", obj);
    }

    public Role read(Long id) {
        return getSqlSession().selectOne("Role.read", id);
    }

    public void update(Role obj) {
        getSqlSession().update("Role.update", obj);
    }

    public void delete(Long id) {
        getSqlSession().delete("Role.delete", id);
    }

    public List<Role> findAll() {
        return null;
    }

    public Role findByName(String name) {
        return null;
    }

    public List<Role> findByUser(Long id) {
        return null;
    }

    public void AddRole(Long idUser) {
    }
    
    @Override
    public void addUserRoles(Long uid) {
        getSqlSession().insert("Role.addUserRoles", uid);
    }
    
    @Override
    public void deleteUserRoles(Long id) {
        getSqlSession().delete("Role.deleteUserRoles", id);
    }
}
