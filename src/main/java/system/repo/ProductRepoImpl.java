package system.repo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import system.model.Product;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepoImpl implements ProductRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    // Methods for Hibernate
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Product> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Transactional
    public void deleteProduct(String id) {
        Product product = (Product) sessionFactory.getCurrentSession().get(Product.class,id);
        if(product!=null){
            sessionFactory.getCurrentSession().delete(product);
        }

    }

    @Transactional
    public void updateProduct(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    @Transactional
    public Product findById(String id) {
        return sessionFactory.getCurrentSession().get(Product.class,id);
    }

}
