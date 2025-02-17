package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();



    @Override
    public List<User> printUsers() {
        return userDao.getAllUsers();
    }

//    @Override
//    public User createUser(User user) {
//       return userDao.createNewUser(user);
//    }
//
//    @Override
//    public void update(Long id, User user) {
//        userDao.getUserById(id);
//    }
//
//    @Override
//    public void delete(Long id) {

//    }
}
