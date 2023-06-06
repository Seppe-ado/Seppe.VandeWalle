package com.example.seppe_vandewalle.Controllers;

import com.example.seppe_vandewalle.Model.DAO.ProductsDAO;
import com.example.seppe_vandewalle.Model.Entities.Products;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProductsController {

    private ProductsDAO mProductsDAO;


    @Autowired
    public ProductsController(ProductsDAO mProductsDAO){
        this.mProductsDAO=mProductsDAO;
    }


    @ModelAttribute("Products")
    public Iterable<Products> getAllProducts() {return mProductsDAO.findAll();}
    @GetMapping({"/","/index"})
    public String IndexPage(){

        return "index";
    }

    @GetMapping("/about")
    public String AboutPage(){
        return "about";
    }


    @ModelAttribute("ProductToAdd")
    public Products ProductToUse(){return new Products();}
    @GetMapping("/new")
    public String NewPage(){
        return "new";
    }

    @PostMapping("/new")
    public String saveProduct(@Valid @ModelAttribute ("ProductToAdd") Products productAdd, BindingResult result) {

        if (result.hasErrors()){
            return "/new";
        }
        mProductsDAO.save(productAdd);
        return "redirect:/index";
    }
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String DetailsPage(ModelMap map, @PathVariable(value = "id") int id){
        Optional<Products> optional1 =mProductsDAO.findById(id);
        if (optional1.isPresent()){
            map.addAttribute("Products",optional1.get());
            return "details";
        }
        return "redirect:/index";
    }

    @GetMapping("/hello")
    public String hello(){return "hello world";}


}
