package com.qf.ssm.dao;

import com.qf.ssm.pojo.Product;

import java.util.List;

public interface ProductDao {

    List<Product> queryAll();

    List<Product> queryByprice();

    List<Product> productsOrderBySaleTimes();

    List<Product> queryByInput(String name);
}
