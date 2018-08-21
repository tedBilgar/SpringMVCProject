package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.model.Product;
import system.model.Select;
import system.service.ProductService;

import java.util.List;

// Новая версия контроллера
@Controller
public class NewProductController {
    @Autowired
    private ProductService productService;

    //Главная страница и READ
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String findAll(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("select",new Select());
        model.addAttribute("listOfProducts",productService.findAll());
        return "jsp/main";
    }

    //CREATE
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product, Model model){
        productService.addProduct(product);
        return "redirect:/";
    }

    //CUSTOM
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public String selectProduct(@ModelAttribute("select") Select select,Model model){
        List<Product> selectProducts = productService.selectProducts(Integer.parseInt(select.getSum()),Integer.parseInt(select.getSelectWeight()));
        model.addAttribute("selectProducts",selectProducts);
        model.addAttribute("select",select);
        model.addAttribute("product",new Product());
        model.addAttribute("listOfProducts",productService.findAll());
        return "jsp/main";
    }

    //DELETE
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id")String id, Model model){
        productService.deleteProduct(id);
        return "redirect:/";
    }

    //UPDATE
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String updateProduct(@PathVariable("id")String id){
        Product product = productService.findById(id);
        product.setPrice("200");
        product.setWeight("200");
        productService.updateProduct(product);
        return "redirect:/";
    }

}
