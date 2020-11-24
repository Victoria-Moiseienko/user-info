package solution.dao;

import java.util.List;
import java.util.Optional;
import solution.model.User;

public interface UserDao {
    Optional<User> getById(Long id);

    void save(List<User> userList);
}
