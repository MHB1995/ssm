package com.qf.ssm.service.impl;

import com.qf.ssm.dao.ProductDao;
import com.qf.ssm.pojo.Product;
import com.qf.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> queryAll() {
        List<Product> products = productDao.queryAll();
        return products;
    }

    @Override
    public List<Product> queryByprice() {
        List<Product> products = productDao.queryByprice();
        return products;
    }

    @Override
    public List<Product> productsOrderBySaleTimes() {
        List<Product> products = productDao.productsOrderBySaleTimes();
        return products;
    }

    @Override
    public List<Product> queryByInput(String name) {
        List<Product> products = productDao.queryByInput(name);
        return products;
    }
}
