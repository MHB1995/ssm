package com.qf.ssm.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int pid;

    private String pname;

    private  int pmoney;

    private  int saletimes;

    private  String pdesc;





}
