package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import system.model.User;
import system.repo.UserRepo;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.addUser(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void deleteUser(String id) {
        userRepo.deleteUser(id);
    }

    public void updateUser(User user) {
        userRepo.updateUser(user);
    }

    public User getUserByUsername(String username) {
        return userRepo.getUserByUsername(username);
    }
}
