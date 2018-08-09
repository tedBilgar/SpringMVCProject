package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.service.ProductService;

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
}
