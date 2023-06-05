package com.example.seppe_vandewalle.Model.DAO;

import com.example.seppe_vandewalle.Model.Entities.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductsDAO extends CrudRepository<Products, Integer> {

//List<Products> findProductsById();

}
