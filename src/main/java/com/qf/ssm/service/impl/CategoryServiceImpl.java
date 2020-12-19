package com.qf.ssm.service.impl;

import com.qf.ssm.dao.CategoryDao;
import com.qf.ssm.pojo.Product;
import com.qf.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Product> queryAll() {
        List<Product> products = categoryDao.queryAll();
        return products;
    }

    @Override
    public List<Product> queryByPhone() {
        List<Product> products = categoryDao.queryByPhone();
        return products;
    }

    @Override
    public List<Product> queryByComputer() {
        List<Product> products = categoryDao.queryByComputer();
        return products;
    }

    @Override
    public List<Product> queryBylothes() {
        List<Product> products = categoryDao.queryBylothes();
        return products;
    }


}
