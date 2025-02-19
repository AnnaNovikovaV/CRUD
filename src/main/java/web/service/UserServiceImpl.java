package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl( UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findOne(int id) {
        Optional<User> foundPerson = userDao.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        updatedUser = userDao.findById(id).orElse(null);
        userDao.save(updatedUser);
    }

    @Transactional
    public void delete(int id) {
        userDao.deleteById(id);
    }
}
