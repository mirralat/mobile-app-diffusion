package com.example.myapplication;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Base64;
import javax.imageio.ImageIO;


public class Decode {
    public static void decodeImage(String base64EncodedImage){
        byte[] imageData = Base64.getDecoder().decode(base64EncodedImage.split(",", 2)[1]);
        return ImageIO.read(new ByteArrayInputStream(imageData));
    }
}
