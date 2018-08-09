package system.service;

import system.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findById(String id);
    public Product findByName(String name);

    public List<Product> selectProducts(int sum,int weight);
}
