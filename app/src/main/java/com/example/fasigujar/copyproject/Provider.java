package com.example.fasigujar.copyproject;

import android.content.Intent;

/**
 * Created by Fasi Gujar on 20-Jun-16.
 */
public class Provider {
    private String item_qun;
    private String pric;

    public Provider(String item_qun, String pric)
    {
        this.setItem_qun(item_qun);
        this.setPric(pric);


    }
    public String getItem_qun() {
        return item_qun;
    }

    public void setItem_qun(String item_qun) {
        this.item_qun = item_qun;
    }

    public String getPric() {
        return pric;
    }

    public void setPric(String pric) {
        this.pric = pric;
    }
}
