package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.model.Product;
import system.repo.ProductRepo;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepo productRepo;

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product findById(String id) {
        return productRepo.findById(id);
    }

    public Product findByName(String name) {
        return productRepo.findByName(name);
    }
}
