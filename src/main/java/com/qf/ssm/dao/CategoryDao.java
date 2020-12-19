package com.qf.ssm.dao;

import com.qf.ssm.pojo.Product;

import java.util.List;

public interface CategoryDao {

    List<Product> queryAll();


    List<Product> queryByPhone();

    List<Product> queryByComputer();

    List<Product> queryBylothes();

}
