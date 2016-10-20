package com.example.fasigujar.copyproject.Models;

/**
 * Created by Mian Mohsin on 10/10/2016.
 */
public class menu_Items {
    private int Id,MenuCatId,AvatarId,Id1,Id2,Id3,manuItemId,UnitPrice,ItemDenomicationId;
    private String Name,ImageUrl,FilePath,name1,name2,name3;

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
    public void setItemDenomicationId(int Id)
    {
        this.ItemDenomicationId=Id;
    }
    public int getItemDenomicationId()
    {
        return ItemDenomicationId;
    }
    public void setUnitPrice(int Id)
    {
        this.UnitPrice=Id;
    }
    public int getUnitPrice()
    {
        return UnitPrice;
    }
    public void setManuItemId(int Id)
    {
        this.manuItemId=Id;
    }
    public int getManuItemId()
    {
        return manuItemId;
    }
    public void setId1(int Id)
    {
        this.Id1=Id;
    }
    public int getId1()
    {
        return Id1;
    }
    public void setId2(int Id)
    {
        this.Id2=Id;
    }
    public int getId2()
    {
        return Id2;
    }
    public void setId3(int Id)
    {
        this.Id3=Id;
    }
    public int getId3()
    {
        return Id3;
    }

    public void setName(String Name)
    {
        this.Name=Name;
    }

    public String getName(){
        return Name;
    }
    public void setImageUrl(String ImgUrl)
    {
        this.ImageUrl=ImgUrl;
    }
    public  String getImageUrl()
    {
        return  ImageUrl;
    }
    public void setFilePath(String FilePath)
    {
        this.FilePath=FilePath;
    }
    public  String getFilePath()
    {
        return  FilePath;
    }
    public void setId(int Id){
         this.Id=Id;
    }
    public int getId()
    {
        return Id;
    }
    public void setMenuCatId(int MenuCatId)
    {
        this.MenuCatId=MenuCatId;
    }
    public int getMenuCatId()
    {
        return MenuCatId;
    }
    public void setAvatarId(int AvatarId)
    {
        this.AvatarId=AvatarId;
    }
    public int getAvatarId()
    {
        return AvatarId;
    }
}
