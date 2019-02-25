package dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import dao.UserDao;
import entity.User;

public class UserMapper extends SqlSessionDaoSupport implements UserDao {

    public void create(User obj) {
        getSqlSession().insert("User.create", obj);
    }

    public User read(Long id) {
        return getSqlSession().selectOne("User.read", id);
    }

    public void update(User obj) {
        getSqlSession().update("User.update", obj);
    }

    public void delete(Long id) {
        getSqlSession().delete("User.delete", id);
    }

    @Override
    public List<User> findAll() {
        return getSqlSession().selectList("User.findAll");
    }

    @Override
    public User findByName(String name) {
        return getSqlSession().selectOne("User.findByName", name);
    }

    @Override
    public User findByEmail(String name) {
        return getSqlSession().selectOne("User.findByEmail", name);
    }

    @Override
    public void updateNoPass(User obj) {
        getSqlSession().update("User.updateNoPass", obj);

    }

}
