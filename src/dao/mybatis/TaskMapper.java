package dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import dao.TaskDao;
import entity.Task;

public class TaskMapper extends SqlSessionDaoSupport implements TaskDao {

	@Override
	public List<Task> findByUserId(Long id) {
		return getSqlSession().selectList("Task.findByUserId", id);
	}

	@Override
	public void deleteByUserId(Long id) {
		getSqlSession().delete("Task.deleteByUserId", id);
	}

	@Override
	public void create(Task obj) {
		getSqlSession().insert("Task.create", obj);
		
	}

	@Override
	public List<Task> findByName(String name) {
		return getSqlSession().selectList("Task.findByName", name);
	}

	public Task read(Long id) {
		return getSqlSession().selectOne("Task.read", id);
	}

	public void update(Task obj) {
		getSqlSession().update("Task.update", obj);
	}

	public void delete(Long id) {
		getSqlSession().delete("Task.delete", id);
	}

	public List<Task> findAll() {
		return getSqlSession().selectList("Task.findAll");
	}

}
