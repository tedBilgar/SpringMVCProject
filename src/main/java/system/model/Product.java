package system.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Product /*implements Comparable<Product>*/{
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private String price;
    private String weight;

    /*public int compareTo(Product o) {
        return Integer.parseInt(this.getPrice()) - Integer.parseInt(o.getPrice());
    }*/
}
