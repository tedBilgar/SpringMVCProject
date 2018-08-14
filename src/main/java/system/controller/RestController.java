package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import system.model.Product;
import system.model.User;
import system.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/rest")
public class RestController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/simple",method = RequestMethod.GET)
    @ResponseBody
    public List<Product> userSignUpPage(Model model){
        List<Product> products = productService.findAll();
        for (Product product:
             products) {
            System.out.println(product);
        }
        return products;
    }
}
