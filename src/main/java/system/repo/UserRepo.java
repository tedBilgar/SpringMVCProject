package system.repo;

import system.model.User;

public interface UserRepo {
    public User getUserByUsername(String username);
}
