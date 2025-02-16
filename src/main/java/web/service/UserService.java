package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> printUsers();
    void createUser(User user);
    void update(Long id, User user);
    void delete(Long id);
}
