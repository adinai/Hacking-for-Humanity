package com.example.test;

import android.app.Application;

public class Globals extends Application {
    private float data=0.0f;

    public float getData(){
        return this.data;
    }

    public void setData(float d){
        this.data= this.data < d ? d : this.data;
    }
}