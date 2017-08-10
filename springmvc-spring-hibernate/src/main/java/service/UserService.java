package service;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 01083446 on 2017/8/9.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User addOne(User user) {
        return userDao.save(user);
    }

    public User findOne(String id) {
        return userDao.findOne(id);
    }

}
