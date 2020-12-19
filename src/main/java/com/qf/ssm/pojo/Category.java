package com.qf.ssm.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private int cid;

    private String cname;

    List<Product> products;



}
