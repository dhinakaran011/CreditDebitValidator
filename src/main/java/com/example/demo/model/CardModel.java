package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class CardModel {
    @Id
    private long atm;
    private long mobile;
    private String name;
    private String bankDetails1;
    private String valid;
    

     public String toString(){
    //    // return name +" : "+mobile+" : "+bankDetails1+" : "+atm;
        return valid;
     }



    public String getBankDetails1()
    {
        return this.bankDetails1;
    }
    public void setBankDetails1(String bankDetails1)
    {
        this.bankDetails1 = bankDetails1;
    }
    


    public long getMobile(){
        return mobile;
    }
    public void setMobile(long mobile){
        this.mobile = mobile;
    }



    public String getValid(){
        return valid;
    }
    public void setValid(String valid){
        this.valid = valid;
    }



    public long getAtm(){
        return atm;
    }
    public void setAtm(long atm){
        this.atm = atm;
    }



    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
