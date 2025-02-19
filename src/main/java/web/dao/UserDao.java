package web.dao;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {


    List<User> findAll();

    Optional<User> findById(int id);

    void save(User user);

    void deleteById(int id);
}
