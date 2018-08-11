package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.model.Product;
import system.repo.ProductRepo;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepo productRepo;

    public List<Product> selectProducts(int sum, int weight) {
        List<Product> products = productRepo.findAll();
        List<Product> selectProducts = new ArrayList<Product>();

        Collections.sort(products, new Comparator<Product>() {
            public int compare(Product o1, Product o2) {
                return Integer.parseInt(o1.getPrice()) - Integer.parseInt(o2.getPrice());
            }
        });

        System.out.println(products);
        int currentSum = 0;
        int currentWeight = 0;
        for (Product product: products) {

            if ((currentSum == 0)&&(currentSum+Integer.parseInt(product.getPrice())<= sum)) {
                selectProducts.add(product);
                currentSum += Integer.parseInt(product.getPrice());
                currentWeight += Integer.parseInt(product.getWeight());
            } else {
                if ((Math.abs(weight - currentWeight) > Math.abs(weight - (currentWeight + Integer.parseInt(product.getWeight()))))&&
                        (currentSum+Integer.parseInt(product.getPrice())<= sum))
                {
                    selectProducts.add(product);
                    currentSum += Integer.parseInt(product.getPrice());
                    currentWeight += Integer.parseInt(product.getWeight());
                } else{
                    System.out.println(selectProducts);
                    return selectProducts;
                }
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        productRepo.addProduct(product);
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public void deleteProduct(String id) {
        productRepo.deleteProduct(id);
    }

    public void updateProduct(Product product) {
        productRepo.updateProduct(product);
    }

    public Product findById(String id) {
        return productRepo.findById(id);
    }
}
