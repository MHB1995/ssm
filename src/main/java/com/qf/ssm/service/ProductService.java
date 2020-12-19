package com.qf.ssm.service;

import com.qf.ssm.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> queryAll();

    List<Product> queryByprice();

    List<Product> productsOrderBySaleTimes();

    List<Product> queryByInput(String name);

}
