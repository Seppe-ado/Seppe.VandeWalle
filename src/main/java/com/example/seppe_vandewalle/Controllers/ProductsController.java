package com.example.seppe_vandewalle.Controllers;

import com.example.seppe_vandewalle.Model.DAO.ProductsDAO;
import com.example.seppe_vandewalle.Model.Entities.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

    @GetMapping("/new")
    public String NewPage(){
        return "new";
    }
    @GetMapping("/details")
    public String DetailsPage(){
        return "details";
    }

    @GetMapping("/hello")
    public String hello(){return "hello world";}
}
