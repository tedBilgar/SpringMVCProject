package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import system.model.Product;
import system.model.Select;
import system.service.ProductService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Properties;

/*Контроллер для API*/
@Controller
@RequestMapping("/rest")
public class RestController {
    @Autowired
    private ProductService productService;

 /*   @Resource(lookup = "sample_custom_resource")
    private Properties properties;
*/
    @RequestMapping(method = RequestMethod.GET)
    public String jqueryPage(){
        return "jsp/jqueryExample";
    }
    @RequestMapping(value = "/ng",method = RequestMethod.GET)
    public String angularPage(Model model){

    /*    ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("angular/example");
        modelAndView.addObject("Title",properties.getProperty("Title"));
*//*
        model.addAttribute("select",new Select());
        model.addAttribute("page-title", properties.getProperty("Title"));*/
        model.addAttribute("Title","ttitti");
        //System.out.println("RRRRRRRRRRRRRRRRR  " + properties.getProperty("Title"));
        return "angular/example";
    }


    // CRUD services
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Product> userFindAll(){
        return productService.findAll();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Product userAdd(@RequestBody Product product){
        productService.addProduct(product);
        return product;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable("id")String id){
        productService.deleteProduct(id);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public Product updateUser(@RequestBody Product product){
        productService.updateProduct(product);
        return product;
    }

    @RequestMapping(value = "/select",method =RequestMethod.GET)
    @ResponseBody
    public List<Product> selectProduct(@RequestParam("price")String price,@RequestParam("weight")String weight){
        return productService.selectProducts(Integer.parseInt(price),Integer.parseInt(weight));
    }


}


