package com.andromeda;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageExactor {
    List<RGB> data = new ArrayList<>();
    private  int height;
    private  int width;

    BufferedImage image;
    ImageExactor(File file) throws IOException {
        this.image = ImageIO.read(file);
    }

    ImageExactor(BufferedImage image){
        this.image = image;
    }
    public   ImageExactor(ImageJson imageJson){
        this.height = imageJson.height;
        this.width = imageJson.width;
        this.data = imageJson.data;
    }
    public  void  createImage(){
         image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        int index = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                RGB rgb = data.get(index++);
                int color = (rgb.red << 16) | (rgb.green << 8) | rgb.blue;
                image.setRGB(x, y, color);
            }
        }

    }

    public void save(String outputPath) throws IOException {
        File outputFile = new File(outputPath);
        ImageIO.write(image, "jpg", outputFile);
    }

    ImageExactor(String path) throws IOException {
        File file = new File(path); // Replace with your image path
        this.image = ImageIO.read(file);
    }

    public  RGB getColorAt(int x,int y){
        // Get the RGB value of the pixel
        int rgb = image.getRGB(x, y);

        // Extract the individual RGB values
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;

        return  new RGB(red,blue,green);
    }

    public void convert(){
        int h = image.getWidth();
        int w = image.getHeight();

        for(int x = 0;x < w;x++){
            for(int y = 0 ; y< h;y++){
                RGB rgb = getColorAt(y,x);
                data.add(rgb);
//                System.out.println("X:"+x+" Y:"+y+" - "+rgb.blue+":"+rgb.green+":"+rgb.red);
            }
        }
    }

    public ImageJson toJson(){
        if(data.isEmpty()){
            convert();
        }
        ImageJson json = new ImageJson(image.getHeight(),image.getWidth(),data);
        return json;
    }



}
