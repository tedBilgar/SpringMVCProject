package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.model.User;
import system.model.UserRoleEnum;

import java.util.HashSet;
import java.util.Set;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;


    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //Находим пользователя с данным юзернеймом
        //Так как данные хранятся в БД, то
        //Через сервис ищем данного юзера
        User user = userService.getUserByUsername(s);
        //Указываем логин
        //Присваиваем роль(и) для данного юзера в юзердетаэилс
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(UserRoleEnum.ADMIN.name()));

        //Производим аутентификацию пользователя
        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(),user.getPassword(),roles);

        return userDetails;
    }

}
