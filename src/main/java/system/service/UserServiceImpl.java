package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.model.User;
import system.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    public User getUserByUsername(String username) {
        return userRepo.getUserByUsername(username);
    }
}
