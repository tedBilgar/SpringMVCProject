package system.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "username")
    @Size(max = 20,min=4,message = "Необходимо от 4 до 20 символов")
    private String username;
    @Column(name = "password")
    @Size(max = 20,min=6,message = "Необходимо от 6 до 20 символов")
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
