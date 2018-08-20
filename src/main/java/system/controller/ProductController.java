package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import system.model.Product;
import system.model.Select;
import system.repo.ProductRepo;
import system.service.ProductService;

import java.util.List;

// Старая версия контроллера
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepo productRepo;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public String findAll(Model model){
        model.addAttribute("products",productService.findAll());
        return "jsp/products";
    }

    @RequestMapping(value = "/id/{productId}",method = RequestMethod.GET)
    public String findById(@PathVariable("productId") String productId,Model model){
        //model.addAttribute("products",productService.findById(productId));
        model.addAttribute("product",productService.findById(productId));
        return "jsp/product";
    }

    @RequestMapping(value = "/name/{productName}",method = RequestMethod.GET)
    public String findByName(@PathVariable("productName") String productName,Model model){
        //model.addAttribute("products",productService.findByName(productName));
       /* model.addAttribute("product",productService.findByName(productName));*/
        return "jsp/product";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product")Product product ){
         return "redirect:main";
    }



    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public String selectProduct(@ModelAttribute Select select,Model model){
        List<Product> selectProducts = productService.selectProducts(Integer.parseInt(select.getSum()),Integer.parseInt(select.getSelectWeight()));
        model.addAttribute("selectProducts",selectProducts);
        model.addAttribute("select",select);
        model.addAttribute("allProducts",productService.findAll());
        return "jsp/selectProducts";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String getForm(){
        return "jsp/form";
    }

    @RequestMapping(value = "/set",method = RequestMethod.GET)
    public String setProducts(){
        System.out.println(productRepo.findAll());
        return "jsp/form";
    }
}
