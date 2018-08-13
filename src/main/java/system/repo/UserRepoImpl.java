package system.repo;

import org.springframework.stereotype.Repository;
import system.model.User;

@Repository
public class UserRepoImpl implements UserRepo {
    public User getUserByUsername(String username) {
        //Временно создаю без базы данных
        User user = new User();
        user.setUsername(username);
        user.setPassword("$2a$04$SRTSWrsS0Nrn1UXtGkR1b.AgkLUErHhyEgGVXS4rp2V2snWaP3ex.");

        return user;
    }
}
