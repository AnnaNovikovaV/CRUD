package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    User findOne(int id);

    void delete(int id);

    void update(int id, User updateUser);


}
