package system.service;

import system.model.User;

public interface UserService {
    public User getUserByUsername(String username);
}
