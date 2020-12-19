package com.qf.ssm.dao;

import com.qf.ssm.BaseTest;
import com.qf.ssm.pojo.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductDaoTest extends BaseTest {

    @Autowired
    private ProductDao productDao;


    @Test
    public void test(){
        List<Product> products = productDao.queryAll();
        System.out.println(products);

    }
}
