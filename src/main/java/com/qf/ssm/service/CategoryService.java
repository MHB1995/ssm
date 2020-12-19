package com.qf.ssm.service;

import com.qf.ssm.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    List<Product> queryAll();


    List<Product> queryByPhone();

    List<Product> queryByComputer();

    List<Product> queryBylothes();

}
