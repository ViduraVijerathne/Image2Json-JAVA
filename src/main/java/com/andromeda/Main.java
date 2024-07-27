package com.andromeda;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
            convertDummy();
            File f = new File("image.json");
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
            imageExactor.save("outputimage.jpg");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }



    public  static  void convertDummy(){
        try {
            ImageExactor exactor = new ImageExactor("src/main/resources/img.png");
            ImageJson json = exactor.toJson();
            String x = json.toJson();

            File f = new File("image.json");
            FileWriter writer = new FileWriter(f);
            writer.write(x);
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error reading the image: " + e.getMessage());
        }
    }
}