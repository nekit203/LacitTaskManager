package service;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;


import dao.RoleDao;

import dao.UserDao;
import entity.Role;

import entity.User;
import mvc.LoginController;
import validation.EmailExistsException;
import validation.EmailNotValidException;
import validation.EmailValidatorImpl;

public class UserServiceImpl implements UserService {


	private final static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    private static final long serialVersionUID = 1L;
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDetailsService uds;

    public void setUds(UserDetailsService uds) {
        this.uds = uds;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }


    @Override
    public User createUserAccount(User account)
            throws EmailExistsException, EmailNotValidException {
    	  EmailValidatorImpl validEmail = new EmailValidatorImpl();
          if (emailExist(account.getEmail())) {
              throw new EmailExistsException(" Email is already exist: " + account.getEmail());
          }
          if (!validEmail.isValid(account.getEmail(), null)) {
              throw new EmailNotValidException("Email is not valid" + account.getEmail());
          }
          User user = new User();
          user.setEmail(account.getEmail());
          user.setPassword(account.getPassword());
          user.setReal_name(account.getReal_name());
          user.setPhone_number("");
          saveUser(user);
          uds.loadUserByUsername(account.getEmail());
          return user;
    }
    
    private boolean emailExist(String email) {
        User user = userDao.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
    
    @Override
    public void saveUser(User user) {
        if (user.getId() == null) {
            userDao.create(user);
            roleDao.addUserRoles(user.getId());
        } else {
            userDao.update(user);
        }
    }

    @Override
    public User getUser(Long id) {
        return userDao.read(id);
    }

    @Override
    public User getUser(String login) {
        return userDao.findByEmail(login);
    }

    @Override
    public User findByEmail(String email) {
        User user = userDao.findByEmail(email);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userDao.delete(id);
    }

 
}
