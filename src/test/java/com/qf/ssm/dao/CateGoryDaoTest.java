package com.qf.ssm.dao;

import com.qf.ssm.BaseTest;
import com.qf.ssm.pojo.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CateGoryDaoTest extends BaseTest {

    @Autowired
    private CategoryDao cateGoryDao;


    @Test
    public void test(){
        List<Product> products = cateGoryDao.queryAll();
        System.out.println(products);
    }

    @Test
    public  void test2(){
        List<Product> products = cateGoryDao.queryByPhone();
        System.out.println(products);
    }


}
