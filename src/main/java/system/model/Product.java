package system.model;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;


@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private String price;
    @Column(name = "weight")
    private String weight;

    public Product() {
    }

    public Product(String name, String price, String weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
}
