package solution.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import solution.dao.UserDao;
import solution.model.User;
import solution.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public void save(List<User> userList) {
        userDao.save(userList);
    }
}
