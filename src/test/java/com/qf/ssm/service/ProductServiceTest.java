package com.qf.ssm.service;

import com.qf.ssm.BaseTest;
import com.qf.ssm.pojo.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceTest extends BaseTest {
    @Autowired
    private ProductService productService;


    @Test
    public void test(){
        List<Product> products = productService.queryAll();
        System.out.println(products);

    }

    @Test
    public void test2(){
        List<Product> products = productService.queryByprice();
        System.out.println(products);

    }
    @Test
    public void test3(){
        List<Product> products = productService.productsOrderBySaleTimes();
        System.out.println(products);

    }
    @Test
    public void test4(){
        List<Product> products = productService.queryByInput("i");
        System.out.println(products);

    }

}
