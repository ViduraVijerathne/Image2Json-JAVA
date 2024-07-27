package com.vidura;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
            convertDummy(args[0]);
            File f = new File(args[0]+".json");
            FileReader  r = new FileReader(f);
            BufferedReader reader = new BufferedReader(r);
            String d = "";
            String data = "";
            while ((d = reader.readLine()) != null){
                data += d;
            }
            data = data.replace(" ","");
            System.out.println(data);
            ImageJson j  = ImageJson.fromJson(data);
            ImageExactor imageExactor = new ImageExactor(j);
            imageExactor.createImage();
            imageExactor.save(args[0]+"-converted.jpg");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }



    public  static  void convertDummy(String path){
        try {
            ImageExactor exactor = new ImageExactor(path+".jpg");
            ImageJson json = exactor.toJson();
            String x = json.toJson();

            File f = new File(path+".json");
            FileWriter writer = new FileWriter(f);
            writer.write(x);
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error reading the image: " + e.getMessage());
        }
    }
}