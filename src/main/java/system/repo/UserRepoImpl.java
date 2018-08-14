package system.repo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import system.model.User;

import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Transactional
    public void deleteUser(String id) {
        User user = sessionFactory.getCurrentSession().get(User.class,id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Transactional
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Transactional
    public User getUserByUsername(String username) {
        //Временно создаю без базы данных
       /* User user = new User();
        user.setUsername(username);
        user.setPassword("$2a$04$SRTSWrsS0Nrn1UXtGkR1b.AgkLUErHhyEgGVXS4rp2V2snWaP3ex.");*/

       User currentUser = new User();
       List<User> users = findAll();
        for (User user: users) {
            if(user.getUsername().equals(username)) {
                currentUser = user;
                break;
            }
        }
        //return sessionFactory.getCurrentSession().get(Product.class,id);
        return currentUser;
    }
}
