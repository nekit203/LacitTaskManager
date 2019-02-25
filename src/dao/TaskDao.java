package dao;

import java.util.List;

import entity.Task;

public interface TaskDao extends CrudDao<Long, Task> {
    
    public List<Task> findAll();

    public List<Task> findByUserId(Long id);
    
    public List<Task> findByName(String name);
    
    void deleteByUserId(Long id);

}
