package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import system.model.Product;
import system.model.Select;
import system.service.ProductService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public String findAll(Model model){
        model.addAttribute("products",productService.findAll());
        return "products";
    }

    @RequestMapping(value = "/id/{productId}",method = RequestMethod.GET)
    public String findById(@PathVariable("productId") String productId,Model model){
        //model.addAttribute("products",productService.findById(productId));
        model.addAttribute("product",productService.findById(productId));
        return "product";
    }

    @RequestMapping(value = "/name/{productName}",method = RequestMethod.GET)
    public String findByName(@PathVariable("productName") String productName,Model model){
        //model.addAttribute("products",productService.findByName(productName));
        model.addAttribute("product",productService.findByName(productName));
        return "product";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String getForm(){
        return "form";
    }

    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public String selectProduct(@ModelAttribute Select select,Model model){
        List<Product> selectProducts = productService.selectProducts(Integer.parseInt(select.getSum()),Integer.parseInt(select.getSelectWeight()));
        model.addAttribute("selectProducts",selectProducts);
        model.addAttribute("select",select);
        model.addAttribute("allProducts",productService.findAll());
        return "selectProducts";
    }
}
