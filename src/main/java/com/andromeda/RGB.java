package com.andromeda;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class RGB   {
    int red;
    int blue;
    int green;
    public RGB(){

    }
    public RGB(int red, int blue, int green) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public  String toJson(){
        return  new Gson().toJson(this);
    }

    public static RGB fromJson(String json) {
        Type imageType = new TypeToken<RGB>(){}.getType();
        return  new Gson().fromJson(json,imageType);
    }
}
