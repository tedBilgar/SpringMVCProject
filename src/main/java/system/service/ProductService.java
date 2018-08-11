package system.service;

import system.model.Product;

import java.util.List;

public interface ProductService {
    public void addProduct(Product product);
    public List<Product> findAll();
    public void deleteProduct(String id);
    public void updateProduct(Product product);

    public Product findById(String id);
    public List<Product> selectProducts(int sum, int weight);
}
