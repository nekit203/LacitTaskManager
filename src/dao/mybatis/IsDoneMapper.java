package dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import dao.IsDoneDao;
import entity.IsDone;

public class IsDoneMapper extends SqlSessionDaoSupport implements IsDoneDao {

    @Override
	public List<IsDone> findAll() {
    	return getSqlSession().selectList("Task.findAll");
	}

	@Override
	public List<IsDone> findByName(String name) {
		return getSqlSession().selectList("Task.findByName", name);
	}

	@Override
	public List<IsDone> findByUserId(Long id) {
		return getSqlSession().selectList("IsDone.findByUserId", id);
	}

	@Override
	public void deleteByUserId(Long id) {
		getSqlSession().delete("Task.deleteByUserId", id);
		
	}

	public void create(IsDone obj) {
        getSqlSession().insert("IsDone.create", obj);
    }

    public IsDone read(Long id) {
        return getSqlSession().selectOne("IsDone.read", id);
    }

    public void update(IsDone obj) {
        getSqlSession().update("IsDone.update", obj);
    }

    public void delete(Long id) {
        getSqlSession().delete("IsDone.delete", id);
    }

}
