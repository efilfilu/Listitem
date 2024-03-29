package com.example.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class detailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    //_______________________________________________________________
        Intent in=getIntent();
        int index=in.getIntExtra("key", -1);

        if (index > -1) {
            int pic=getImage(index);
            ImageView img=(ImageView) findViewById(R.id.imageView);
            scaleImage(img, pic);
        }
    }
    private int getImage(int index){
        switch (index){
            case 0: return R.drawable.peach;
            case 1: return R.drawable.tomato;
            case 2: return R.drawable.squash;
            default: return -1;

        }
    }
    private void scaleImage(ImageView img, int pic){
        Display screen= getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options= new BitmapFactory.Options();

        options.inJustDecodeBounds=true; //********

        BitmapFactory.decodeResource(getResources(),pic,options);
        int imageView=options.outWidth;
        int screenWidth=screen.getWidth();
        if(imageView > screenWidth){
            int ratio=Math.round((float)imageView/(float)screenWidth);
            options.inSampleSize=ratio;
        }

        options.inJustDecodeBounds=false; //*******

        Bitmap scaledaImage=BitmapFactory.decodeResource(getResources(),pic,options);
        img.setImageBitmap(scaledaImage);

    }
}
