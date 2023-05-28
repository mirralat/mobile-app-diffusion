package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;


import java.io.ByteArrayInputStream;
import java.io.IOException;


public class Decode {
    public static Bitmap decodeImage(String base64EncodedImage){

        byte[] imageData = Base64.decode(base64EncodedImage.split(",", 2)[1],
                    Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageData, 0, imageData.length);
    }
}
