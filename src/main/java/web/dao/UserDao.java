package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {


    List<User> findAll();

    User findById(int id);

    void save(User user);

    void deleteById(int id);
}
