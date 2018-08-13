package system.repo;

import org.springframework.stereotype.Repository;
import system.model.User;

@Repository
public class UserRepoImpl implements UserRepo {
    public User getUserByUsername(String username) {
        //Временно создаю без базы данных
        User user = new User();
        user.setUsername(username);
        user.setPassword("123456");

        return user;
    }
}
