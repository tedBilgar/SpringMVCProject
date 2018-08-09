package system.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class Select {
    private String sum;
    private String selectWeight;

    public Select() {
    }
}
