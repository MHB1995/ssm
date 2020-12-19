package com.qf.ssm.controller;


import com.qf.ssm.pojo.Product;
import com.qf.ssm.service.CategoryService;
import com.qf.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("phone")
    public List<Product> queryByPhone(){
        List<Product> products = categoryService.queryByPhone();
        return products;
    }
    @GetMapping("computer")
    public List<Product> queryByComputer(){
        List<Product> products = categoryService.queryByComputer();
        return products;
    }

    @GetMapping("clothes")
    public List<Product> queryBylothes()  {
        List<Product> products = categoryService.queryBylothes();
        return products;
    }
}
