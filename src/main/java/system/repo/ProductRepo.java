package system.repo;

import system.model.Product;

import java.util.List;

public interface ProductRepo {
    public void addProduct(Product product);
    public List<Product> findAll();
    public void deleteProduct(String id);
    public void updateProduct(Product product);

    public Product findById(String id);
}
