package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
   private EntityManager entityManager;

    @Override
    public void add(User user) {
        add(new User(1L, "Ivan", "Ivanov"));
        add(new User(2L, "Petr", "Petrov"));
        add(new User(3L, "Sidor", "Sidorov"));
        add(new User(4L, "Vladimir", "Vladimirov"));
    }

    @Override
    public List<User> AllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }


    public void createNewUser( User user) {
        EntityTransaction transaction = null;
//        try {
//            transaction = eManager.getTransaction();
//            transaction.begin();
//            eManager.persist(user);
//            transaction.commit();
//        } catch (Exception e) {
//                transaction.rollback();
//
//        }
        entityManager.persist(user);
        entityManager.flush();
    }

    public void deleteUser(Long id) {
//        EntityTransaction transaction = null;
//        try {
//            transaction = entityManager.getTransaction();
//            transaction.begin();
//            User user = entityManager.find(User.class, id);
//            if (user != null) {
//                entityManager.remove(user); // Удалите сущность
//            } else {
//                System.out.println("Пользователь с id " + id + " не найден. Невозможно удалить.");
//                // Рассмотрите возможность выброса исключения здесь, если отсутствие пользователя является ошибкой
//            }
//            transaction.commit();
//        } catch (Exception e) {
//                transaction.rollback();
//            }
        User user = getUserById(id);
        if (null == user) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
        entityManager.flush();
    }

    public void updateUser(int id, User user) {
//        EntityTransaction transaction = null;
//        try {
//            transaction = entityManager.getTransaction();
//            transaction.begin();
//            User existingUser = entityManager.find(User.class, id);
//            if (existingUser != null) {
//                user.setId(id); // Убедитесь, что ID установлен
//                entityManager.merge(user);
//            } else {
//                System.out.println("Пользователь с id " + id + " не найден. Невозможно обновить.");
//                // Рассмотрите возможность выброса исключения здесь, если отсутствие пользователя является ошибкой
//            }
//            transaction.commit();
//        } catch (Exception e) {
//                transaction.rollback();
//        }
        entityManager.merge(user);
        entityManager.flush();
    }
}
