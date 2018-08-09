package system.repo;

import system.model.Product;

import java.util.List;

public interface ProductRepo {
    public List<Product> findAll();
    public Product findById(String id);
    public Product findByName(String name);
}
