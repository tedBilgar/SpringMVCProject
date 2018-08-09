package system.repo;

import org.springframework.stereotype.Repository;
import system.model.Product;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepoImpl implements ProductRepo {

    private List<Product> products = Arrays.asList(new Product("1","Coca-Cola","24","80"),
            new Product("2","Tea","80","120"),
            new Product("3","Coffee","120","200"),
            new Product("4","Bread","80","250"),
            new Product("5","Water","10","500"),
            new Product("6","Juice","80","40"),
            new Product("7","Snickers","200","140"),
            new Product("8","Apple","90","300"));
    public List<Product> findAll() {
        return products;
    }

    public Product findById(String id) {
        for (Product product:products) {
            if(product.getId().equals(id)) return product;
        }
        return null;
    }

    public Product findByName(String name) {
        for (Product product:products) {
            if(product.getName().equals(name)) return product;
        }
        return null;
    }
}
