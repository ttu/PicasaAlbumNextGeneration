package com.ttu.picasaalbumnextgeneration;

import android.content.Intent;
import android.view.View;

public class ImageListener implements View.OnClickListener 
{
    private String mImage;

    public ImageListener(String image) {
    	mImage = image;
    }

    @Override
    public void onClick(View v) {
    	Intent detailIntent = new Intent(v.getContext(), ImageActivity.class);
    	detailIntent.putExtra("ImageUri", mImage);
    	v.getContext().startActivity(detailIntent);             
    }
}
