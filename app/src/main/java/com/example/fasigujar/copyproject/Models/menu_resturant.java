package com.example.fasigujar.copyproject.Models;

/**
 * Created by Mian Mohsin on 10/9/2016.
 */
public class menu_resturant {
    private String Name,FilePath;
    private int AvatarId,Id;

    public String getName()
    {
        return Name;
    }
    public void setName(String Name)
    {
        this.Name=Name;
    }
    public String getFilePath()
    {
        return FilePath;
    }
    public void setFilePath(String FilePath)
    {
        this.FilePath=FilePath;
    }
    public int getAvatarId() {
        return AvatarId;
    }

    public void setAvatarId(int AvatarId) {
        this.AvatarId = AvatarId;
    }
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
}
