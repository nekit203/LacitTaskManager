package dao;

import java.util.List;

import entity.User;

public interface UserDao extends CrudDao<Long, User> {
    
    public List<User> findAll();

    public User findByName(String name);
    
    public User findByEmail(String name);
    
    public void updateNoPass(User obj);

    

}