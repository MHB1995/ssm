package com.qf.ssm.pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

     private String id;
     private String name;
     private String money;
     private String address;
     private String state;
     private String date;
     private String thumb;
}
