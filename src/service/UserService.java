package service;

import java.util.List;

import entity.User;
import validation.EmailExistsException;
import validation.EmailNotValidException;

public interface UserService {
	
	User getUser(Long id);

	User getUser(String login);

	User findByEmail(String email);

	List<User> getUsers();

	void deleteUser(Long id);

	User createUserAccount(User account) throws EmailExistsException, EmailNotValidException;

	void saveUser(User user);
}
