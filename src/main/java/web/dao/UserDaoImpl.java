package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
   private  EntityManager entityManager;

    public UserDaoImpl() {
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void deleteById(int id) {

//        Optional<User> user = findById(id);
//        if (!user.isPresent()) {
//            throw new NullPointerException("User not found");
//        }
        findById(id).ifPresent(entityManager::remove);
//        entityManager.remove(user);
        entityManager.flush();
    }
}
