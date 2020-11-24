package solution.service;

import java.util.List;
import java.util.Optional;
import solution.model.User;

public interface UserService {
    Optional<User> getById(Long id);

    void save(List<User> userList);
}
