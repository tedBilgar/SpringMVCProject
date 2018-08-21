package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import system.model.Product;
import system.model.Select;
import system.service.ProductService;

import java.util.List;

/*Контроллер для API*/
@Controller
@RequestMapping("/rest")
public class RestController {
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String jqueryPage(){
        return "jsp/jqueryExample";
    }
    @RequestMapping(value = "/ng",method = RequestMethod.GET)
    public String angularPage(Model model){
        model.addAttribute("select",new Select());
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


