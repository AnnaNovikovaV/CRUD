package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> getAllUsers();
//
//    User getUserById(Long id);
//
//    User createNewUser(User user);
//
//    void deleteUser(Long id);
}
