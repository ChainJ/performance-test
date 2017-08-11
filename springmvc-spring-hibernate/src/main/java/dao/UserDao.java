package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by JiangCheng on 2017/8/11.
 */
@Repository
public class UserDao {
    private SessionFactory sessionFactory = new Configuration()
            .configure("config/hibernate.cfg.xml").buildSessionFactory();

    public User findOne(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        User user = session.find(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    public List<User> findList(int offset, int limit) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        Query query = session.createQuery("SELECT u FROM User u", User.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        List<User> users = query.getResultList();
        session.getTransaction().commit();
        return users;
    }

    public User add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        int id = (int) session.save(user);
        User result = session.find(User.class, id);
        session.getTransaction().commit();
        return result;
    }

    public List<User> add(Collection<User> users) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        List<Integer> ids = users.stream().map(u -> (int) session.save(u)).collect(Collectors.toList());
        List<User> result = new ArrayList<>();
        for (int id : ids) {
            result.add(session.find(User.class, id));
        }
        session.getTransaction().commit();
        return result;
    }

    public List<User> update(Collection<User> users) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        users.forEach(session::update);
        List<User> result = new ArrayList<>();
        for (User u : users) {
            result.add(session.find(User.class, u.getId()));
        }
        session.getTransaction().commit();
        return result;
    }
}
