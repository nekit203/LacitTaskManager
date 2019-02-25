package dao;

import java.util.List;

import entity.IsDone;

public interface IsDoneDao extends CrudDao<Long, IsDone> {
	
    public List<IsDone> findAll();
    
    public List<IsDone> findByName(String name);

    public List<IsDone> findByUserId(Long id);
    
    void deleteByUserId(Long id);
    
}
