
# Image2Json Java Library



## Overview

Image2Json is a Java library designed to convert images to JSON format and vice versa. This library allows for easy manipulation and storage of image data by converting the image's RGB values into a JSON structure, making it ideal for image processing and data serialization tasks.
## Convert Image to Json Example

 ```
 try {
            ImageExactor exactor = new ImageExactor("src/main/resources/img.png");
            ImageJson json = exactor.toJson();
            String x = json.toJson();

            File f = new File("image.json");
            FileWriter writer = new FileWriter(f);
            writer.write(x);
            writer.flush();
        } 
catch (IOException e) {
            System.out.println("Error reading the image: " + e.getMessage());
}
```
## Convert  Json to Image Example

```
try{
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

```
