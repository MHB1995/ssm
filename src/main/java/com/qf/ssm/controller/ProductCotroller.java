package com.qf.ssm.controller;


import com.qf.ssm.pojo.Person;
import com.qf.ssm.pojo.Product;
import com.qf.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductCotroller {

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public List<Product> products(){
        List<Product> products = productService.queryAll();

        return products;
    }

    @GetMapping("orderByprice")
    public List<Product> productsOrderByprice(){
        List<Product> products = productService.queryByprice();

        return products;
    }

    @GetMapping("orderBySaleTimes")
    public List<Product> productsOrderBySaleTimes(){
        List<Product> products = productService.productsOrderBySaleTimes();

        return products;
    }

    @GetMapping("queryByInput")
    public List<Product> queryByInput(String name)  {
        List<Product> products = productService.queryByInput(name);
        return products;
    }



}
