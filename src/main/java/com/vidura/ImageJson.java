package com.vidura;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ImageJson {
    int height;
    int width;
    List<RGB> data;

    ImageJson(int height,int width,List<RGB> data){
        this.height = height;
        this.width = width;
        this.data = data;
    }
    ImageJson(int height,int width){
        this.height = height;
        this.width = width;
    }


    public  String toJson(){
        Gson gson = new Gson();
        return  gson.toJson(this);
    }

    public static  ImageJson fromJson(String json){
        Type imageType = new TypeToken<ImageJson>(){}.getType();
        return  new Gson().fromJson(json,imageType);
    }

}
