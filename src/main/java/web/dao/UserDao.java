package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> AllUsers();

    User getUserById(Long id);

    void createNewUser(User user);

    void deleteUser(Long id);
}
