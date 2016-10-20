package com.example.fasigujar.copyproject.Models;

/**
 * Created by Mian Mohsin on 10/10/2016.
 */
public class single_item {
    private int quantity;
    private String FilePath,name1,name2,name3,UnitPrice,quantityId;


    public void setQuantityId(String Name)
    {
        this.quantityId=Name;
    }

    public String getQuantityId(){
        return quantityId;
    }
    public void setQuantity(int Name)
    {
        this.quantity=Name;
    }

    public int getQuantity(){
        return quantity;
    }
    public void setName3(String Name)
    {
        this.name3=Name;
    }

    public String getName3(){
        return name3;
    }

    public void setName1(String Name)
    {
        this.name1=Name;

    }

    public String getName1(){
        return name1;
    }
    public void setName2(String Name)
    {
        this.name2=Name;
    }

    public String getName2(){
        return name2;
    }
    public void setUnitPrice(String Id)
    {
        this.UnitPrice=Id;
    }
    public String  getUnitPrice()

    {
        return UnitPrice;
    }


    public void setFilePath(String FilePath)
    {
        this.FilePath=FilePath;
    }
    public  String getFilePath()
    {
        return  FilePath;
    }

}
