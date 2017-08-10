package dao;

import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by JiangCheng on 2017/8/10.
 */
public class UserDAO {
    private static SqlSessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("config/mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User findOne(int id) {
        SqlSession session = sessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.findOne(id);
        session.commit();
        session.close();
        return user;
    }

    public List<User> findList(int offset, int limit) {
        SqlSession session = sessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> users = userMapper.findList(offset, limit);
        session.commit();
        session.close();
        return users;
    }

    public void add(User user) {
        SqlSession session = sessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.add(user);
        session.commit();
        session.close();
    }

    public void update(User user) {
        SqlSession session = sessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.update(user);
        session.commit();
        session.close();
    }

    public void update(Collection<User> users) {
        SqlSession session = sessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        users.forEach(userMapper::update);
        session.commit();
        session.close();
    }

}
