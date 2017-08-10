package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

/**
 * Created by 01083446 on 2017/8/9.
 */
@Repository
public class UserDao {
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public User save(User user) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, session.save(user));
    }

    public User findOne(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

}
