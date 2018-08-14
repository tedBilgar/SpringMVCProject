package system.repo;

import system.model.Product;
import system.model.User;

import java.util.List;

public interface UserRepo {
    public void addUser(User user);
    public List<User> findAll();
    public void deleteUser(String id);
    public void updateUser(User user);


    public User getUserByUsername(String username);
}
