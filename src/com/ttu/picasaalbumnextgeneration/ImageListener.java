package com.ttu.picasaalbumnextgeneration;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;

public class ImageListener implements View.OnClickListener 
{
    private Uri mImage;

    public ImageListener(Uri image) {
    	mImage = image;
    }

    @Override
    public void onClick(View v) {
    	Intent detailIntent = new Intent(v.getContext(), ImageActivity.class);
    	detailIntent.putExtra("ImageUri", mImage.toString());
    	v.getContext().startActivity(detailIntent);             
    }

}
